package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;
import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinTree;

/**
 * Binary Search Tree
 */
public class BST extends BinTree<Integer> {
    protected BinNode<Integer> _hot;

    public BST(BinNode<Integer> root) {
        super(root);
    }

    public BinNode<Integer> search(Integer e) {
        return searchIn(_root, e);
    }

    /**
     * @param v 根节点
     * @param e 查找的数据
     * @return 命中的接口, 不存在则为null
     */
    private BinNode<Integer> searchIn(BinNode<Integer> v, Integer e) {
        if (v == null || e.equals(v.data)) {
            return v;
        }
        _hot = v;
        return searchIn((e < v.data ? v.lChild : v.rChild), e);
    }

    public BinNode<Integer> insert(Integer e) {
        BinNode<Integer> x = search(e);
        if (x == null) {
            if (e < _hot.data) {
                x = _hot.insertAsLC(e);
            } else {
                x = _hot.insertAsRC(e);
            }
            _size++;
            updateHeightAbove(x);
        }
        return x;
    }

    public boolean remove(Integer e) {
        BinNode<Integer> x = search(e);
        if (x == null) {
            return false;
        }
        removeAt(x);
        _size--;
        updateHeightAbove(_hot);
        return true;
    }

    private BinNode<Integer> removeAt(BinNode<Integer> x) {
        BinNode<Integer> succ;
        if (!x.hasLChild()) {
            //左子树为空
            succ = x.rChild;
        } else if (!x.hasRChild()) {
            //右子树为空
            succ = x.lChild;
        } else {
            //左右都不为空
            BinNode<Integer> w = x.succ();
            swap(x, w);
            x = w;
            succ = x.rChild;
        }
        if (succ != null) {
            succ.parent = x.parent;
        }
        _hot = x.parent;
        if (x.isLChild()) {
            x.parent.lChild = succ;
        } else {
            x.parent.rChild = succ;
        }
        return succ;
    }

    private void swap(BinNode<Integer> x, BinNode<Integer> w) {
        Integer temp = x.data;
        x.data = w.data;
        w.data = temp;
    }

    @Override
    public String toString() {
        traversalLevel(integer -> {
            System.out.print(" " + integer);
        });
        return "BST{" +
                "_root=" + _root +
                '}';
    }
}
