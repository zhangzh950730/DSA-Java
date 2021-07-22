package com.zzh.leetcode.链表;

/**
 * @author ZhangZhiHao
 * @date 2021/7/22 9:40
 */
public class CopyRandomList_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node p = head;

            //第一步，在每个原节点后面创建一个新节点
            //1->1'->2->2'->3->3'
            while (p != null) {
                Node newNode = new Node(p.val);
                newNode.next = p.next;
                p.next = newNode;
                p = p.next.next;
            }

            //第二步，设置新节点的随机节点
            p = head;
            while (p != null) {
                if (p.random != null) {
                    p.next.random = p.random.next;
                }
                p = p.next.next;
            }

            //第三步，将两个链表分离
            Node dummy = new Node(-1);
            Node current = dummy;
            p = head;
            while (p != null) {
                current.next = p.next;
                current = current.next;
                p.next = current.next;
                p = p.next;
            }
            return dummy.next;
        }
    }
}
