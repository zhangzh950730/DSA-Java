package com.zzh.leetcode.竞赛.周赛._358;

import com.zzh.leetcode.ListNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2_doubleIt {

    public static void main(String[] args) {
        _2_doubleIt doubleIt = new _2_doubleIt();
        ListNode head, ans;

        head = new ListNode(9, new ListNode(9, new ListNode(9)));
        ans = doubleIt.doubleIt(head);
        System.out.println("ans = " + ans);
    }

    public ListNode doubleIt(ListNode head) {
        if (head.val >= 5) head = new ListNode(0, head);
        for (ListNode curr = head; curr != null; curr = curr.next) {
            int carry = 0;
            if (curr.next != null && curr.next.val >= 5) carry = 1;
            curr.val = (curr.val * 2 + carry) % 10;
        }
        return head;
    }
}
