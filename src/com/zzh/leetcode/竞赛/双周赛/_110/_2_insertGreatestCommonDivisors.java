package com.zzh.leetcode.竞赛.双周赛._110;

import com.zzh.leetcode.ListNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2_insertGreatestCommonDivisors {

    public static void main(String[] args) {
        _2_insertGreatestCommonDivisors insertGreatestCommonDivisors = new _2_insertGreatestCommonDivisors();
        ListNode head, ans;

        head = new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))));
        ans = insertGreatestCommonDivisors.insertGreatestCommonDivisors(head);
        System.out.println("ans = " + ans);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            curr.next = new ListNode(gcd(curr.val, curr.next.val), curr.next);
            curr = curr.next.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
