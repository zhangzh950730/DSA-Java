package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;
import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinTree;

/**
 * Binary Search Tree
 */
public abstract class BST extends BinTree<Integer> {

    public BinNode<Integer> search(Integer e) {
        return searchIn(_root, e, _hot = null);
    }

    /**
     * @param v 根节点
     * @param e 查找的数据
     * @param hot 总是指向命中节点的父亲
     * @return 命中的接口,不存在则为null
     */
    private BinNode<Integer> searchIn(BinNode<Integer> v, Integer e, BinNode<Integer> hot) {
        if (v == null || e.equals(v.data)) {
            return v;
        }
        hot = v;
        return searchIn((e < v.data ? v.lChild : v.rChild), e, hot);
    }

    public abstract BinNode<Integer> insert(Integer e);

    public abstract boolean remove(Integer e);

    protected BinNode<Integer> _hot;

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
