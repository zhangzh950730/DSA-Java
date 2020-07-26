package com.zzh.数据结构_邓俊辉.chapter5_二叉树;

/**
 * @author zhangzhihao
 * @date 2020/7/26 10:03
 */
public class BinNode<T> {
    protected BinNode<T> lChild, rChild, parent;
    protected T data;
    protected int height;
    private Object npl;
    private BinNodeColor color;

    public BinNode(T data, BinNode<T> parent) {
        this.parent = parent;
        this.data = data;
    }

    public BinNode<T> insertAslC(T data) {
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
}
