package com.zzh.leetcode.链表;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @author zhangzhihao
 * @date 2020/6/1 16:58
 */
public class AddTwoNumbers_2 {
    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyNode;
            int carry = 0;
            while (p != null || q != null) {
                int x = p != null ? p.val : 0;
                int y = q != null ? q.val : 0;
                int sum = x + y + carry;
                curr = curr.next = new ListNode(sum % 10);
                carry = sum / 10;
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyNode.next;
        }

        public static void main(String[] args) {
            ListNode l1 = new ListNode(2);
            l1.next = new ListNode(4);
            l1.next.next = new ListNode(3);

            ListNode l2 = new ListNode(5);
            l2.next = new ListNode(6);
            l2.next.next = new ListNode(4);

            ListNode result = addTwoNumbers(l1, l2);
            System.out.println(result);

            ListNode l3 = new ListNode(1);
            ListNode l4 = new ListNode(9);
            l4.next = new ListNode(9);
            result = addTwoNumbers(l3, l4);
            System.out.println(result);
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}



