package com.zzh.leetcode._101_200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _141_hasCycle {
    public static void main(String[] args) {
        _141_hasCycle hasCycle = new _141_hasCycle();
        ListNode head;
        boolean ans;

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        head = node1;
        ans = hasCycle.hasCycle(head);
        Assert.assertTrue(ans);

        node1 = new ListNode(1);
        node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;
        head = node1;
        ans = hasCycle.hasCycle(head);
        Assert.assertTrue(ans);

        head = new ListNode(1);
        ans = hasCycle.hasCycle(head);
        Assert.assertFalse(ans);

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
