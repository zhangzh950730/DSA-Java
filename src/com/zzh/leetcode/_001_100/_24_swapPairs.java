package com.zzh.leetcode._001_100;

import com.zzh.leetcode.ListNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _24_swapPairs {
    public static void main(String[] args) {
        _24_swapPairs swapPairs = new _24_swapPairs();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode ans = swapPairs.swapPairs(head);
        System.out.println("ans = " + ans);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0, head);
        ListNode pre = sentinel;
        ListNode left = pre.next, right = left.next;
        while (left != null && right != null) {
            left.next = right.next;
            right.next = left;
            pre.next = right;

            pre = left;
            left = left.next;
            if (left != null) right = left.next;
        }
        return sentinel.next;
    }
}
