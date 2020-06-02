package com.zzh.leetcode.链表;

import java.util.List;

/**
 * 反转链表
 *
 * @author zhangzhihao
 * @date 2020/6/2 11:29
 */
public class ReverseList_206 {
    /**
     * 迭代,哨兵节点
     */
    static class Solution {
        public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode tempNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNext;
            }
            return prev;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            ListNode reverseList = reverseList(head);
            System.out.println(reverseList);
        }
    }


}
