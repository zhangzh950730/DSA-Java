package com.zzh.leetcode._001_100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _23_mergeKLists {

    public static void main(String[] args) {
        _23_mergeKLists mergeKLists = new _23_mergeKLists();
        ListNode[] lists;
        ListNode ans;

        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        lists = new ListNode[]{node1, node2, node3};
        ans = mergeKLists.mergeKLists(lists);
        System.out.println("ans = " + ans);

    }

    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (ListNode node : lists) {
            while (node != null) {
                counter.merge(node.val, 1, Integer::sum);
                node = node.next;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer key : counter.keySet()) pq.offer(key);

        ListNode ans = new ListNode();
        ListNode pre = ans;
        while (!pq.isEmpty()) {
            Integer poll = pq.poll();
            Integer count = counter.merge(poll, -1, Integer::sum);
            if (count > 0) pq.offer(poll);
            pre.next = new ListNode(poll);
            pre = pre.next;
        }
        return ans.next;
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
