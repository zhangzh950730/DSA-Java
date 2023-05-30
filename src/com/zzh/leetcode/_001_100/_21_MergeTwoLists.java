package com.zzh.leetcode._001_100;

import javax.print.attribute.SetOfIntegerSyntax;

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
        ListNode p1 = list1, p2 = list2;
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        curr.next = p1 == null ? p2 : p1;
        return sentinel.next;
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
