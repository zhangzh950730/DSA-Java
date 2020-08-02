package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;
import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinTree;

/**
 * Binary Search Tree
 */
public class BST extends BinTree<Integer> {
    protected BinNode<Integer> _hot;

    public BST() {

    }

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

    public BinNode<Integer> removeAt(BinNode<Integer> x) {
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

    /**
     * 理想平衡条件
     */
    public boolean balanced(BinNode<Integer> x) {
        return stature(x.lChild) == stature(x.rChild);
    }

    /**
     * 平衡因子
     */
    public int balFac(BinNode<Integer> x) {
        return stature(x.lChild) - stature(x.rChild);
    }


    public BinNode<Integer> tallerChild(BinNode<Integer> x) {
        return stature(x.lChild) > stature(x.rChild) ? x.lChild :
                stature(x.lChild) < stature(x.rChild) ? x.rChild :
                        isLChild(x) ? x.lChild : x.rChild;
    }

    public boolean isLChild(BinNode<Integer> x) {
        return x.parent.lChild == x;
    }

    public BinNode<Integer> connect34(BinNode<Integer> a, BinNode<Integer> b, BinNode<Integer> c,
                                      BinNode<Integer> t0, BinNode<Integer> t1, BinNode<Integer> t2, BinNode<Integer> t3) {
        a.lChild = t0;
        if (t0 != null) {
            t0.parent = a;
        }
        a.rChild = t1;
        if (t1 != null) {
            t1.parent = a;
        }

        c.lChild = t2;
        if (t2 != null) {
            t2.parent = c;
        }
        c.rChild = t3;
        if (t3 != null) {
            t3.parent = c;
        }

        b.lChild = a;
        a.parent = b;
        b.rChild = c;
        c.parent = b;

        updateHeight(a);
        updateHeight(c);
        updateHeight(b);
        return b;
    }

    public boolean isRoot(BinNode<Integer> x) {
        return root() == x;
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
