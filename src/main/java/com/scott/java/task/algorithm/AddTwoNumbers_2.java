package com.scott.java.task.algorithm;

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

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0, value;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode tempNode = new ListNode(0);
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            value = sum % 10;
            tempNode.val = value;
            head.next = tempNode;
            head = tempNode;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;

        }
        return result.next;
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


