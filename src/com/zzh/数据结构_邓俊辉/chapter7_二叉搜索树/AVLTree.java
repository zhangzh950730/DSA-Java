package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

import com.zzh.数据结构_邓俊辉.chapter5_二叉树.BinNode;

/**
 * @author zhangzhihao
 */
public class AVLTree extends BST {

    public AVLTree() {

    }

    public AVLTree(BinNode<Integer> root) {
        super(root);
    }

    @Override
    public BinNode<Integer> insert(Integer e) {
        BinNode<Integer> x = search(e);
        if (x != null) {
            return x;
        }
        if (e < _hot.data) {
            x = _hot.insertAsLC(e);
        } else {
            x = _hot.insertAsRC(e);
        }
        _size++;

        for (BinNode<Integer> g = _hot; g != null; g = g.parent) {
            if (!avlBalanced(g)) {
                BinNode<Integer> tempG = g;
                g = rotateAt(tallerChild(tallerChild(g)));
                if (isRoot(tempG)) {
                    _root = g;
                } else if (isLChild(g)) {
                    tempG.parent.lChild = g;
                } else {
                    tempG.parent.rChild = g;
                }

                break;
            } else {
                updateHeightAbove(g);
            }
        }
        return x;
    }

    @Override
    public boolean remove(Integer e) {
        BinNode<Integer> x = search(e);
        if (x == null) {
            return false;
        }
        removeAt(x);
        _size--;

        for (BinNode<Integer> g = _hot; g != null; g = g.parent) {
            if (!avlBalanced(g)) {
                g = rotateAt(tallerChild(tallerChild(g)));
                updateHeight(g);
            }
        }
        return true;
    }

    public BinNode<Integer> rotateAt(BinNode<Integer> v) {
        BinNode<Integer> p = v.parent;
        BinNode<Integer> g = p.parent;
        if (isLChild(p)) {
            if (isLChild(v)) {
                p.parent = g.parent;
                return connect34(v, p, g, v.lChild, v.rChild, p.rChild, g.rChild);
            } else {
                v.parent = g.parent;
                return connect34(p, v, g, p.lChild, v.lChild, v.rChild, g.rChild);
            }
        } else {
            if (isLChild(v)) {
                v.parent = g.parent;
                return connect34(g, v, p, g.lChild, v.lChild, v.rChild, p.rChild);
            } else {
                p.parent = g.parent;
                return connect34(g, p, v, g.lChild, p.lChild, v.lChild, v.rChild);
            }
        }
    }

    public boolean avlBalanced(BinNode<Integer> x) {
        return -2 < balFac(x) && balFac(x) < 2;
    }

}
