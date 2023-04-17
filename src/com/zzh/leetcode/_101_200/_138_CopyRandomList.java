package com.zzh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangZhiHao
 * @date 2021/7/22 9:40
 */
public class _138_CopyRandomList {
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

    /**
     * https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/
     * 解法1
     */
    class Solution1 {
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

    /**
     * https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/
     * 解法2
     */
    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Map<Node, Node> map = new HashMap<>();
            Node p = head;
            while (p != null) {
                Node newNode = new Node(p.val);
                map.put(p, newNode);
                p = p.next;
            }

            p = head;
            while (p != null) {
                Node newNode = map.get(p);
                if (p.next != null) {
                    newNode.next = map.get(p.next);
                }
                if (p.random != null) {
                    newNode.random = map.get(p.random);
                }
                p = p.next;
            }
            return map.get(head);
        }
    }
}
