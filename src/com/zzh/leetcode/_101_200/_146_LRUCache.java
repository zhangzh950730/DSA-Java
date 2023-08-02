package com.zzh.leetcode._101_200;

import org.junit.Assert;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _146_LRUCache {
    public static void main(String[] args) {
        int ans;
        LRUCache lruCache = new LRUCache(2);

        ans = lruCache.get(2);
        Assert.assertEquals(-1, ans);

        lruCache.put(2, 6);

        ans = lruCache.get(1);
        Assert.assertEquals(-1, ans);

        lruCache.put(1, 5);
        lruCache.put(1, 2);

        ans = lruCache.get(1);
        Assert.assertEquals(2, ans);

        ans = lruCache.get(2);
        Assert.assertEquals(6, ans);

    }

    static class LRUCache {
        class DLinkedNode {
            Integer key;
            Integer value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(Integer key, Integer value) {
                this.key = key;
                this.value = value;
            }
        }

        private Integer size;
        private final Integer capacity;
        private final DLinkedNode head;
        private final DLinkedNode tail;
        private final Map<Integer, DLinkedNode> map;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            DLinkedNode node = map.get(key);
            if (node == null) return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = map.get(key);
            if (node != null) {
                node.value = value;
                moveToHead(node);
            } else {
                node = new DLinkedNode(key, value);
                map.put(key, node);
                addToHead(node);
                ++size;
                if (size > capacity) {
                    node = removeTail();
                    map.remove(node.key);
                    --size;
                }
            }
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode ans = tail.prev;
            removeNode(ans);
            return ans;
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
