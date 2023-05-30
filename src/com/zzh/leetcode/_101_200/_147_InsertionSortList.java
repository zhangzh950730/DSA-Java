package com.zzh.leetcode._101_200;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _147_InsertionSortList {

    public static void main(String[] args) {
        _147_InsertionSortList insertionSortList = new _147_InsertionSortList();
        ListNode head, ans;

        head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ans = insertionSortList.insertionSortList(head);
        System.out.println("ans = " + ans);

        head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ans = insertionSortList.insertionSortList(head);
        System.out.println("ans = " + ans);

    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        // 前置哨兵节点
        ListNode sentinelHead = new ListNode(Integer.MIN_VALUE, head);
        // 最后一个已排序节点
        ListNode lastSorted = head;
        // 下一个待排序节点
        ListNode curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = sentinelHead;
                while (prev.next.val <= curr.val) prev = prev.next;
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return sentinelHead.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



