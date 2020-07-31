package com.zzh.数据结构_邓俊辉.chapter5_二叉树;

/**
 * @author zhangzhihao
 * @date 2020/7/26 10:03
 */
public class BinNode<T> {
    public BinNode<T> lChild, rChild, parent;
    public T data;
    public int height;
    public Object npl;
    public BinNodeColor color;

    public BinNode(T data, BinNode<T> parent) {
        this.parent = parent;
        this.data = data;
    }

    public BinNode<T> insertAsLC(T data) {
        return lChild = new BinNode<>(data, this);
    }

    public BinNode<T> insertAsRC(T data) {
        return rChild = new BinNode<>(data, this);
    }

    public int size() {
        int size = 1;
        if (lChild != null) {
            size += lChild.size();
        }
        if (rChild != null) {
            size += rChild.size();
        }
        return size;
    }

    public BinNode<T> succ() {
        BinNode<T> s = this;
        if (rChild != null) {
            s = rChild;
            while (s.hasLChild()) {
                s = s.lChild;
            }
        } else {
            while (s.isRChild()) {
                s = s.parent;
            }
            s = s.parent;
        }
        return s;
    }

    public boolean isRChild() {
        return parent.rChild == this;
    }

    public boolean isLChild() {
        return parent.lChild == this;
    }

    public boolean hasRChild() {
        return rChild != null;
    }

    public boolean hasLChild() {
        return lChild != null;
    }
}
