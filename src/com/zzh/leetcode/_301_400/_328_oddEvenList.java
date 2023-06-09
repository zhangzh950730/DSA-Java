package com.zzh.leetcode._301_400;

import com.zzh.leetcode.ListNode;
import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _328_oddEvenList {

    public static void main(String[] args) {
        _328_oddEvenList oddEvenList = new _328_oddEvenList();
        ListNode head, ans;

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ans = oddEvenList.oddEvenList(head);
        Assert.assertEquals(ans, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4))))));

        head = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ans = oddEvenList.oddEvenList(head);
        Assert.assertEquals(ans, new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(7, new ListNode(1, new ListNode(5, new ListNode(4))))))));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, evenHead = head.next, even = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}
