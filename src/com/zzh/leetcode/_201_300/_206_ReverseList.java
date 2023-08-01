package com.zzh.leetcode._201_300;

/**
 * 反转链表
 *
 * @author zhangzhihao
 * @date 2020/6/2 11:29
 */
public class _206_ReverseList {
    public static void main(String[] args) {
        _206_ReverseList reverseList = new _206_ReverseList();
        ListNode head, ans;

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ans = reverseList.reverseList(head);
        System.out.println("ans = " + ans);

        head = new ListNode(1, new ListNode(2));
        ans = reverseList.reverseList(head);
        System.out.println("ans = " + ans);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}




