package com.scott.java.task.bloomfilter;

import java.util.BitSet;

/**
 * @author scott
 * @date 2019/1/24 19:28
 */

public class SimpleBloomFilter {
    private static final int DEFAULT_SIZE = 2 << 24;
    private static final int[] seeds = new int[]{7, 11, 13, 31, 37, 61,};

    private BitSet bits = new BitSet(DEFAULT_SIZE);
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public static void main(String[] args) {
       /**
        *   此处是正常的布隆过滤器使用
        *    String value = " stone2083@yahoo.cn ";
        *    SimpleBloomFilter filter = new SimpleBloomFilter();
        *    System.out.println(filter.contains(value));
        *    filter.add(value);
        *    System.out.println(filter.contains(value));
        */

        // 1.此处是验证假如get的值超过了BitSet的范围是否会报错？
        // 查看BitSet.get()方法的实现 发现只有index小于BitSet的时候才会报错
        // 如果是大于BitSet的数组下标会返回false 而不会抛出异常

        // 综合第1,2条来看, hash() 返回的值位数不会超过BitSet的长度, 返回值即使超出了
        // BitSet的范围也不会有问题.

        SimpleBloomFilter filter = new SimpleBloomFilter();
        System.out.println(filter.bits.get(50331648));
        System.out.println(3 << 24);
    }

    public SimpleBloomFilter() {
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
    }

    public void add(String value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (SimpleHash f : func) {
            System.out.println(f.hash(value));
            System.out.println(bits.get(f.hash(value)));
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    public static class SimpleHash {

        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            // 2. 因为一个短数字和一个长数字做与运算 出来的结果a 不会多与短数字的位数  所以a不会超出短数字的位数
            // 而且因为cap是2 << 24左右
            return (cap - 1) & result;
        }

    }

}

