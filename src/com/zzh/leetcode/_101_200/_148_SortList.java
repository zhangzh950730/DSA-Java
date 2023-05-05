package com.zzh.leetcode._101_200;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _148_SortList {

    public static void main(String[] args) {
        _148_SortList sortList = new _148_SortList();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        sortList.sortList(head);
        head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        sortList.sortList(head);
        head = new ListNode();
        sortList.sortList(head);
    }

    public ListNode sortList(ListNode head) {
        // TODO ZhangZhiHao
        return null;
    }

}

class ListNode {
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
