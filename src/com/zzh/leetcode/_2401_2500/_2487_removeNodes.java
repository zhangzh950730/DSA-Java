package com.zzh.leetcode._2401_2500;

import com.zzh.leetcode.ListNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2487_removeNodes {
    public static void main(String[] args) {

    }

    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        } else return head;
    }

}
