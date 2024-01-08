package com.zzh.leetcode._2801_2900;

import com.zzh.leetcode.ListNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2807_insertGreatestCommonDivisors {

    public static void main(String[] args) {

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        for (ListNode p = head; p.next != null; p = p.next.next) {
            p.next = new ListNode(gcd(p.val, p.next.val), p.next);
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

}
