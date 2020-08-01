package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;

/**
 * @author zhangzhihao
 */
public class AVL extends BST {

    public AVL(BinNode<Integer> root) {
        super(root);
    }

    @Override
    public BinNode<Integer> insert(Integer e) {
        BinNode<Integer> x = search(e);
        if (x == null) {
            return x;
        }
        x = new BinNode<>(e, _hot);
        _size++;

        for (BinNode<Integer> g = _hot; ; g = g.parent) {
            if (!avlBalanced(g)) {
                rotateAt(tallerChild(tallerChild(g)));
                break;
            } else {
                updateHeightAbove(g);
            }
        }
        return x;
    }

    private BinNode<Integer> tallerChild(BinNode<Integer> x) {
        return stature(x.lChild) > stature(x.rChild) ? x.lChild :
                stature(x.lChild) < stature(x.rChild) ? x.rChild :
                        IsLChild(x) ? x.lChild : x.rChild;
    }

    private boolean IsLChild(BinNode<Integer> x) {
        return x.parent.lChild == x;
    }

    @Override
    public boolean remove(Integer e) {
        return false;
    }

    public BinNode<Integer> connect34(BinNode<Integer> a, BinNode<Integer> b, BinNode<Integer> c,
                                      BinNode<Integer> t0, BinNode<Integer> t1, BinNode<Integer> t2, BinNode<Integer> t3) {
        //TODO
        return null;
    }

    public BinNode<Integer> rotateAt(BinNode<Integer> v) {
        //TODO
        return null;
    }

    public boolean avlBalanced(BinNode<Integer> x) {
        return -2 < balFac(x) && balFac(x) < 2;

    }

}
