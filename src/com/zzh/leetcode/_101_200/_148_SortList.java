package com.zzh.leetcode._101_200;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _148_SortList {

    public static void main(String[] args) {
        _148_SortList sortList = new _148_SortList();
        ListNode head, ans;

        head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ans = sortList.sortList(head);
        System.out.println("ans = " + ans);

        head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ans = sortList.sortList(head);
        System.out.println("ans = " + ans);

        head = new ListNode();
        ans = sortList.sortList(head);
        System.out.println("ans = " + ans);
    }

    private ListNode merge(ListNode listNode1, ListNode listNode2) {
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                curr.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                curr.next = listNode2;
                listNode2 = listNode2.next;
            }
            curr = curr.next;
        }
        curr.next = listNode1 == null ? listNode2 : listNode1;
        return sentinel.next;
    }

    /**
     * 自低向上归并
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        ListNode sentinel = new ListNode(0, head);
        for (int i = 1; i < length; i <<= 1) {
            ListNode prev = sentinel, curr = sentinel.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int j = 1; j < i && curr.next != null; j++) {
                    curr = curr.next;
                }

                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int j = 1; j < i && curr != null && curr.next != null; j++) {
                    curr = curr.next;
                }

                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }

                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return sentinel.next;
    }

    /**
     * 自顶向下归并
     * 时间复杂度O(nlogn)
     * 空间复杂度O(logn)
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode listNode1 = sortList(head);
        ListNode listNode2 = sortList(temp);

        return merge(listNode1, listNode2);
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


