package com.zzh.数据结构_邓俊辉.chapter5_二叉树;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinTreeTest {
    private BinTree<Integer> binTree;

    @BeforeEach
    void before() {
        binTree = new BinTree<>(new BinNode<>(5, null));
        BinNode<Integer> root = binTree._root;
        assertEquals(root.height, 0);

        binTree.insertAsLC(root, 3);
        binTree.insertAsRC(root, 8);
        assertEquals(root.height, 1);

        binTree.insertAsLC(root.lChild, 1);
        binTree.insertAsRC(root.lChild, 4);
        binTree.insertAsLC(root.rChild, 6);
        binTree.insertAsRC(root.rChild, 10);
        assertEquals(root.height, 2);

        binTree.insertAsRC(root.lChild.lChild, 2);
        binTree.insertAsRC(root.rChild.lChild, 7);
        binTree.insertAsLC(root.rChild.rChild, 9);
        assertEquals(root.height, 3);
    }


    @Test
    void preOrder1() {
        binTree.preOrder1(binTree.root(), integer -> {
            System.out.print(" " + integer);
        });
    }

    @Test
    void preOrder2() {
        binTree.preOrder2(binTree.root(), integer -> {
            System.out.print(" " + integer);
        });
    }

    @Test
    void preOrder3() {
        binTree.preOrder3(binTree.root(), integer -> {
            System.out.print(" " + integer);
        });
    }

    @Test
    void inOrder() {
        binTree.inOrder(binTree.root(), integer -> {
            System.out.print(" " + integer);
        });
    }

    @Test
    void traversalLevel() {
        binTree.traversalLevel(integer -> {
            System.out.print(" " + integer);
        });
    }
}