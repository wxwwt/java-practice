package com.scott.java.task.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author scott
 * @date 2019/3/7 19:48
 */

public class LongestSubString {

    private static int longestSub = 0;

    private static Map<Character, Integer> map = new HashMap<>();

    public static int maxSub(String str) {
        if (str.equals("") || str == null) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        if (map.containsKey(str.charAt(0))) {
            return longestSub;
        } else {
            map.put(str.charAt(0), 1);
            longestSub = maxSub(str.substring(1)) + 1;
        }
        return longestSub;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int longestSub(String str) {
        int length = str.length();
        int max = 0;
        char[] arr = str.toCharArray();
        int left = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            if (map.containsKey(arr[i])) {
                left = i - 1;
            }
            map.put(arr[i], i);
            max = Math.max(max, i - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSub("bbb"));
    }
}
