package com.zzh.algs4.chapter3.section3;

/**
 * @author ZhangZhiHao
 * @date 2021/7/22 15:04
 */
public class RedBlackTree<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N; //这颗子树的节点总数
        boolean color;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }
}
