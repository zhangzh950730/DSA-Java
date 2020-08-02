package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;
import org.junit.jupiter.api.Test;

class AVLTreeTest {

    @Test
    void insert() {
        AVLTree avlTree = new AVLTree(new BinNode<>(8, null));
        avlTree.insert(7);
        avlTree.insert(12);
        avlTree.insert(11);
        avlTree.insert(14);
        avlTree.insert(13);
    }

    @Test
    void remove() {
    }

}