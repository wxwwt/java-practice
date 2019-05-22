package com.scott.java.task.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 最长子回文串
 *
 * @author scott
 * @date 2019/5/20 22:29
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubstring.longestPalindrome("ababa"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome(""));
    }

    public static String longestPalindrome(String s) {
        if (s.length() > 1000 || s == null) {
            return null;
        }
        if (s.equals("")) {
            return "";
        }

        char[] charArr = s.toCharArray();
        // 使用双向队列来保存最大的子串
        Deque<Character> deque = new ArrayDeque();
        String longestStr = String.valueOf(charArr[0]);
        int maxInt = 0;


        for (int i = 0; i < charArr.length; i++) {
            deque.clear();
            int head = 0;
            int tail = 0;
            int flag = 0;
            // 偶数回文  用来判断回文数的两个数字的下标不能超过最大下标
            if (i + 1 <= charArr.length - 1 && charArr[i] == charArr[i + 1]) {
                head = i;
                tail = i + 1;
                flag = 1;
            }
            // 奇数回文
            if (i + 2 <= charArr.length - 1 && charArr[i] == charArr[i + 2]) {
                head = i;
                tail = i + 2;
                flag = 1;
                // 奇数的把中间轴对称的数先放入双向队列
                deque.addFirst(charArr[i + 1]);
            }
            // 有相等的数才循环 否则 直接略过
            if (flag == 1) {
                while (head >= 0 && tail <= charArr.length - 1) {
                    if (charArr[head] == charArr[tail]) {
                        deque.addFirst(charArr[head]);
                        deque.addLast(charArr[tail]);
                        --head;
                        ++tail;
                    } else {
                        break;
                    }
                }
            }
            if (deque.size() > maxInt) {
                maxInt = deque.size();
                Character[] aa = deque.toArray(new Character[deque.size()]);
                char[] bb = new char[1000];
                for (int j = 0; j < aa.length; j++) {
                    bb[j] = aa[j];
                }
                longestStr = String.valueOf(bb).trim();
            }
        }
        return longestStr;
    }
}