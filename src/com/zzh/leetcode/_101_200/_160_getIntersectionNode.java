package com.zzh.leetcode._101_200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _160_getIntersectionNode {
    public static void main(String[] args) {
        _160_getIntersectionNode getIntersectionNode = new _160_getIntersectionNode();
        ListNode headA, headB, ans;

        ListNode suffix = new ListNode(8, new ListNode(4, new ListNode(5)));
        headA = new ListNode(4, new ListNode(1, suffix));
        headB = new ListNode(5, new ListNode(6, new ListNode(1, suffix)));
        ans = getIntersectionNode.getIntersectionNode(headA, headB);
        Assert.assertEquals(ans.val, 8);

        headA = new ListNode(2, new ListNode(6, new ListNode(4)));
        headB = new ListNode(1, new ListNode(5));
        ans = getIntersectionNode.getIntersectionNode(headA, headB);
        Assert.assertNull(ans);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
