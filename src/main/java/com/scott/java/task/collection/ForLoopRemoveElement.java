package com.scott.java.task.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author scott
 * @date 2020/4/12 20:32
 */
public class ForLoopRemoveElement {

    private List<String> list = new ArrayList<String>() {{
        add("element1");
        add("element2");
        add("element3");
    }};

    public void test1() {
        for (int i = 0; i < list.size() - 1; i++) {
            if ("element3".equals(list.get(i))) {
                System.out.println("found element3!");
            }

            if ("element2".equals(list.get(i))) {
                list.remove(i);
            }
        }

    }


    public void test2() {
        for (int i = 0; i < list.size() - 1; i++) {
            if ("element2".equals(list.get(i))) {
                list.remove(i);
            }

            if ("element3".equals(list.get(i))) {
                System.out.println("found element3!");
            }
        }
    }


    public void test3() {
       /* for (String item : list) {
            if ("element2".equals(item)) {
                list.remove(item);
            }

            if ("element3".equals(item)) {
                System.out.println("found element3!");
            }
        }*/
       // 上面的代码反编译就是这个
        Iterator var1 = this.list.iterator();

        while(var1.hasNext()) {
            String item = (String)var1.next();
            if ("element2".equals(item)) {
                this.list.remove(item);
            }

            if ("element3".equals(item)) {
                System.out.println("found element3!");
            }
        }
    }

    public void test4() {
        list.forEach(
                item -> {
                    if ("element2".equals(item)) {
                        list.remove(item);
                    }

                    if ("element3".equals(item)) {
                        System.out.println("found element3!");
                    }
                }
        );
    }


    public void test5() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("element2".equals(iterator.next())) {
                iterator.remove();
            }

            if ("element3".equals(iterator.next())) {
                System.out.println("found element3!");
            }
        }
    }

    public void test6() {
        list.removeIf(item -> "element2".equals(item));
    }

    public static void main(String[] args) {
        ForLoopRemoveElement test = new ForLoopRemoveElement();
//        test.test1();
//        test.test2();
        test.test5();
//        test.test4();
//        test.test5();
//        test.test6();
    }
}