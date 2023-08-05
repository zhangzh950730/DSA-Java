package com.zzh.leetcode._001_100;

import com.zzh.leetcode.ListNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _21_MergeTwoLists {

    public static void main(String[] args) {
        _21_MergeTwoLists mergeTwoLists = new _21_MergeTwoLists();
        ListNode listNode1, listNode2, ans;

        listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ans = mergeTwoLists.mergeTwoLists(listNode1, listNode2);
        System.out.println("ans = " + ans);

        listNode1 = null;
        listNode2 = null;
        ans = mergeTwoLists.mergeTwoLists(listNode1, listNode2);
        System.out.println("ans = " + ans);

        listNode1 = null;
        listNode2 = new ListNode(0);
        ans = mergeTwoLists.mergeTwoLists(listNode1, listNode2);
        System.out.println("ans = " + ans);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode pre = head, p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }
        if (p1 != null) {
            pre.next = p1;
        } else {
            pre.next = p2;
        }
        return head.next;
    }


}
