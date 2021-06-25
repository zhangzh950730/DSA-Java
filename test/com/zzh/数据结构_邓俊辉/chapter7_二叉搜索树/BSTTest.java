package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {
    private BST bst;

    @BeforeEach
    void before() {
        bst = new BST(new BinNode<>(20, null));
        BinNode<Integer> root = bst.root();
        assertEquals(root.height, 0);

        bst.insertAsLC(root, 10);
        bst.insertAsRC(root, 38);
        assertEquals(root.height, 1);

        bst.insertAsLC(root.lChild, 5);
        bst.insertAsRC(root.lChild, 11);
        bst.insertAsLC(root.rChild, 25);
        bst.insertAsRC(root.rChild, 48);
        assertEquals(root.height, 2);

        bst.insertAsLC(root.lChild.lChild, 2);
        bst.insertAsRC(root.lChild.lChild, 8);
        bst.insertAsRC(root.lChild.rChild, 15);
        bst.insertAsLC(root.rChild.lChild, 23);
        bst.insertAsRC(root.rChild.lChild, 29);
        bst.insertAsLC(root.rChild.rChild, 43);
        bst.insertAsRC(root.rChild.rChild, 87);
        assertEquals(root.height, 3);

        bst.insertAsRC(root.lChild.lChild.lChild, 4);
        bst.insertAsLC(root.lChild.rChild.rChild, 13);
        bst.insertAsRC(root.lChild.rChild.rChild, 18);
        bst.insertAsRC(root.rChild.lChild.rChild, 32);
        bst.insertAsRC(root.rChild.rChild.rChild, 63);
        assertEquals(root.height, 4);
    }

    @Test
    void search() {
        int e = 28;
        BinNode<Integer> search = bst.search(e);
        assertNull(search);
        assertEquals(bst._hot.data, 29);

        e = 29;
        search = bst.search(e);
        assertEquals(search.data, 29);
        assertEquals(bst._hot.data, 25);
    }

    @Test
    void insert() {
        int oldSize = bst.size();
        BinNode<Integer> binNode = bst.insert(28);
        assertEquals(binNode.parent.data, 29);
        assertEquals(bst.root().height, 4);
        assertEquals(bst._size, ++oldSize);

        binNode = bst.insert(27);
        assertEquals(binNode.parent.data, 28);
        assertEquals(bst.root().height, 5);
        assertEquals(bst._size, ++oldSize);
    }

    @Test
    void remove() {
        int oldSize = bst.size();

        boolean remove = bst.remove(8);
        assertTrue(remove);
        assertEquals(bst.size(), --oldSize);

        remove = bst.remove(2);
        assertTrue(remove);
        assertEquals(bst.size(), --oldSize);

        remove = bst.remove(10);
        assertTrue(remove);
        assertEquals(bst.size(), --oldSize);
        System.out.println(bst);
    }
}