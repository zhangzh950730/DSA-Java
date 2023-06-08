package com.zzh.leetcode._001_100;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _92_reverseBetween {

    public static void main(String[] args) {
        _92_reverseBetween reverseBetween = new _92_reverseBetween();
        ListNode head, ans;
        int left, right;

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        left = 2;
        right = 4;
        ans = reverseBetween.reverseBetween(head, left, right);
        System.out.println("ans = " + ans);

        head = new ListNode(5);
        left = 1;
        right = 1;
        ans = reverseBetween.reverseBetween(head, left, right);
        System.out.println("ans = " + ans);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode pre = sentinel;
        for (int i = 1; i < left; i++) pre = pre.next;
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) rightNode = rightNode.next;
        ListNode leftNode = pre.next;
        ListNode next = rightNode.next;

        pre.next = null;
        rightNode.next = null;
        reverseLinkedList(leftNode);
        pre.next = rightNode;
        leftNode.next = next;

        return sentinel.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
