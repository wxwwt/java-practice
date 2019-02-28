package com.scott.java.task.algorithm;

/**
 * 判断一个字符串是否另一个字符串的子串
 * @author scott
 * @date 2019/2/28 13:03
 */

public class subStr {

    public static boolean subStr(String raw, String sub) {
        char[] rawArr = raw.toCharArray();
        char[] subArr = sub.toCharArray();
        int i = 0, j = 0;
        if (sub.equals("") && !raw.equals("")) {
            return false;
        }
        while (i < raw.length()) {
            if (rawArr[i] == subArr[j]) {
                ++i;
                ++j;
            } else if (j == 0) {
                i++;
            } else {
                j = 0;
            }
        }
        if (j == subArr.length) {
            return true;
        }
        return false;
    }

    /**
     * 思路: abcad 和 ab 使用两个指针,i,j分别表示两个字符串的位置
     *   1. 排除一些边界和特殊情况
     *   2.如果相等 i++,j++
     *   3.不相等 && j == 0的时候 i++ 原始串的指针继续后移
     *   4.不相等 && j !=0 的时候 子串的指针还原 因为已经有不相等的部分了
     *
     */


    public static void main(String[] args) {
        System.out.println(subStr("abcaddabcd", "abcd"));
        System.out.println(subStr("abcad", ""));
        System.out.println(subStr("", ""));
        System.out.println(subStr("", "fdaf"));
    }
}
