package com.scott.java.task.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;

/**
 * @author scott
 * @date 2019/7/21 17:34
 */
public class SerializableAndDeserializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "data.txt";
        testSerializable(fileName);
        testDeserializable(fileName);
        testTransient();
        testExternalizable();
    }

    private static void testSerializable(String fileName) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // "XXX" 的String也可以直接作为对象进行反序列化的
            objectOutputStream.writeObject("test serializable");
            SerializableData data = new SerializableData(1, "testStr");
            objectOutputStream.writeObject(data);
        }
    }

    private static void testDeserializable(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            String str = (String) objectInputStream.readObject();
            System.out.println("String的反序列化: " + str);
            SerializableData readData = (SerializableData) objectInputStream.readObject();
            System.out.println("反序列化的对象: " + readData.toString());
            // 反序列化的对象: SerializableData(testInt=1, testStr=testStr)
        }
    }

    private static void testTransient() throws IOException, ClassNotFoundException {
        String fileName = "transientData.txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Account data = new Account(1, "user1", "123456");
            out.writeObject(data);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Account readData = (Account) in.readObject();
            System.out.println("transient关键字的对象: " + readData.toString());
            // 输出: transient关键字的对象: Account(id=1, userName=user1, idCardNumber=null)
        }
    }

    private static void testExternalizable() throws IOException, ClassNotFoundException {
        String fileName = "testExternalizable.txt";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Account3 data = new Account3("user1", 1);
            out.writeObject(data);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Account3 readData = (Account3) in.readObject();
            System.out.println("Externalizable的对象: " + readData.toString());
            /**
             * 输出:
             * 执行了writeExternal方法
             * 执行了readExternal方法
             * Externalizable的对象: Account3(userName=user1, id=1)
             */
        }
    }
}


@Data
@AllArgsConstructor
class SerializableData implements Serializable {

    private Integer testInt;

    private String testStr;
}

@Data
@AllArgsConstructor
class Account implements Serializable {

    private transient int id;

    private String userName;

    private transient String idCardNumber;
}


@Data
@AllArgsConstructor
class Account2 implements Externalizable {

    private String userName;

    private Integer id;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("执行了writeExternal方法");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("执行了readExternal方法");
    }
}

@ToString
class Account3 implements Externalizable {

    private String userName;

    private Integer id;

    public Account3() {

    }

    public Account3(String userName, Integer id) {
        this.userName = userName;
        this.id = id;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("执行了writeExternal方法");
        out.writeObject(userName);
        out.writeInt(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("执行了readExternal方法");
        userName = (String) in.readObject();
        id = in.readInt();

    }
}





