package com.zzh.数据结构_邓俊辉.chapter5_二叉树;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinNodeTest {
    private BinNode<Integer> root;
    private BinNode<Integer> lChild;
    private BinNode<Integer> rChild;

    @BeforeEach
    void before() {
        root = new BinNode<>(2, null);
    }

    @Test
    void insertAslC() {
        BinNode<Integer> lc = root.insertAsLC(1);
        System.out.println(root);
        assertEquals(root.lChild, lc);
        lChild = lc;
    }

    @Test
    void insertAsRC() {
        BinNode<Integer> rc = root.insertAsRC(3);
        System.out.println(root);
        assertEquals(root.rChild, rc);
        rChild = rc;
    }

    @Test
    void succ() {
        insertAsRC();
        BinNode<Integer> succ = root.succ();
        assertEquals(succ.data, 3);
    }

    @Test
    void hasRChild() {
        insertAsRC();
        boolean hasRChild = root.hasRChild();
        assertTrue(hasRChild);
    }

    @Test
    void hasLChild() {
        insertAslC();
        boolean hasLChild = root.hasLChild();
        assertTrue(hasLChild);
    }

    @Test
    void size() {
        insertAsRC();
        insertAslC();
        assertEquals(root.size(), 3);
    }

    @Test
    void isRChild() {
        insertAsRC();
        assertTrue(rChild.isRChild());
    }

    @Test
    void isLChild() {
        insertAslC();
        assertTrue(lChild.isLChild());
    }
}