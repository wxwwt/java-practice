package com.scott.java.task.algorithm;

import lombok.val;

/**
 * @author scott
 * @date 2019/2/28 13:40
 */

public class AddTwoNumbers_2 {

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode a2 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode c2 = new ListNode(4);
        a2.next = b2;
        b2.next = c2;
        ListNode re = solution(a, a2);
        System.out.println(re);
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        int carry = 0;
        for (int i = 0; l1.next != null || l2.next != null; ++i, l1 = l1.next, l2 = l2.next) {
            if (i == 0) {
                if (l1.val + l2.val >= 10) {
                    result.val = l1.val + l2.val - 10;
                    carry = 1;
                } else {
                    result.val = l1.val + l2.val;
                }
            } else {
                if (l1.val + l2.val + carry >= 10) {
                    result.next = new ListNode(l1.val + l2.val + carry - 10);
                    carry = 1;
                } else {
                    result.next = new ListNode(l1.val + l2.val + carry);
                    carry = 0;
                }
            }
        }
        return result;
    }

    public static int listNodeCycle(ListNode l1) {
        int result = 0;
        for (int i = 0; l1.next != null; i++) {
            int temp = 1;
            // 手动实现整数次幂
            for (int j = 0; j < i; ++j) {
                temp *= 10;
            }
            result = result + l1.val * temp;
        }
        return result;
    }


}


