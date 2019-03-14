package com.scott.java.task.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author scott
 * @date 2019/3/7 19:48
 */

public class LongestSubString_3 {

    public static int longestSub(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSub("abba"));
        System.out.println(longestSub("dvdf"));
        System.out.println(longestSub("pwwekw"));
        System.out.println(longestSub("abcabcbb"));
        System.out.println(longestSub("bbbbb"));
    }
}
