package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;
import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinTree;

/**
 * Binary Search Tree
 */
public abstract class BST extends BinTree<Integer> {
    protected BinNode<Integer> _hot;

    public BinNode<Integer> search(Integer e) {
        return searchIn(_root, e, _hot = null);
    }

    /**
     * @param v   根节点
     * @param e   查找的数据
     * @param hot 总是指向命中节点的父亲
     * @return 命中的接口, 不存在则为null
     */
    private BinNode<Integer> searchIn(BinNode<Integer> v, Integer e, BinNode<Integer> hot) {
        if (v == null || e.equals(v.data)) {
            return v;
        }
        hot = v;
        return searchIn((e < v.data ? v.lChild : v.rChild), e, hot);
    }

    public BinNode<Integer> insert(Integer e) {
        BinNode<Integer> x = search(e);
        if (x == null) {
            x = new BinNode<>(e, _hot);
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
        removeAt(x, _hot);
        _size--;
        updateHeightAbove(_hot);
        return true;
    }

    private BinNode<Integer> removeAt(BinNode<Integer> x, BinNode<Integer> hot) {
        BinNode<Integer> w = x; //实际被删除的节点,初值同x
        BinNode<Integer> succ = null; //实际被删除节点的接替者
        if (!x.hasLChild()) { //左子树为空
            succ = x = x.rChild;
        } else if (!x.hasRChild()) { //右子树为空
            succ = x = x.lChild;
        } else { //左右都不为空
            w = w.succ();
            swap(x, w); //令x与其后继w互换数据
            BinNode<Integer> u = w.parent; //原问题转化为,删除非二度的节点w
            if (u == x) {
                u.rChild = succ = w.rChild;
            } else {
                u.lChild = succ = w.rChild;
            }

        }
        hot = w.parent;
        if (succ != null) {
            succ.parent = hot;
        }
        return succ;
    }

    private void swap(BinNode<Integer> x, BinNode<Integer> w) {
        Integer temp = x.data;
        x.data = w.data;
        w.data = temp;
    }

    protected BinNode<Integer> connect34(BinNode<Integer> a, BinNode<Integer> b, BinNode<Integer> c,
                                         BinNode<Integer> t0, BinNode<Integer> t1, BinNode<Integer> t2, BinNode<Integer> t3) {
        //TODO
        return null;
    }

    protected BinNode<Integer> rotateAt(BinNode<Integer> v) {
        //TODO
        return null;
    }


}
