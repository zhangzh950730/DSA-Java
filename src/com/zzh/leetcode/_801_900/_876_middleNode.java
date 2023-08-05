package com.zzh.leetcode._801_900;

import com.zzh.leetcode.ListNode;
import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _876_middleNode {

    public static void main(String[] args) {
        _876_middleNode middleNode = new _876_middleNode();
        ListNode head, ans;

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ans = middleNode.middleNode(head);
        Assert.assertEquals(ans.val, 3);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ans = middleNode.middleNode(head);
        Assert.assertEquals(ans.val, 4);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
