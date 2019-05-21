package com.scott.java.task.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shenchuang
 * @since 2019-05-21
 */
public class LongestSubString {

    public static void main(String[] args) {
        Deque<Character> deque = new ArrayDeque();
        deque.addFirst('a');
    }

    public String getLongestSubString(String rawStr) {
        char[] charArr = rawStr.toCharArray();
        // 使用双向队列来保存最大的子串
        Deque<Character> deque = new ArrayDeque();
        String longestStr = null;
        int maxInt = 0;
        if (charArr.length > 1000) {
            return "length is over than limit";
        }
        for (int i = 0; i < charArr.length; i++) {
            // 偶数回文
            if (charArr[i] == charArr[i + 1] && i + 1 <= charArr.length) {
                deque.addFirst(charArr[i]);
                deque.addLast(charArr[i+1]);
                int head = i;
                int tail = i + 1;
                while (head == 0 || tail == charArr.length) {
                    deque.addFirst(charArr[head]);
                    deque.addLast(charArr[tail]);
                    --head;
                    ++tail;
                }
                if (deque.size() > maxInt) {
                    maxInt = deque.size();
                 //   longestStr = deque.toArray();
                }
            //    deque.size()
                List list = new ArrayList();
                list.add(deque.size(), deque);

//                String tempStr = new String(temp);
//                map.put(deque.toArray().length);
            }
            // 奇数回文
            if (charArr[i] == charArr[i+2] && i + 2 <= charArr.length) {

            }
        }
        return null;
    }
}
