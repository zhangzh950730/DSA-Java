package com.zzh.数据结构_邓俊辉.chapter3_列表;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/23 20:33
 * <p>
 * 列表节点类
 */
public class ListNode<T> {
    /**
     * 数据
     */
    T data;

    /**
     * 前驱/后继节点
     */
    ListNode<T> pred, succ;

    public ListNode() {
    }

    public ListNode(T data, ListNode<T> pred, ListNode<T> succ) {
        this.data = data;
        this.pred = pred;
        this.succ = succ;
    }

    ListNode<T> insertAsPred(T e) {
        ListNode<T> x = new ListNode<>(e, pred, this);
        pred.succ = x;
        pred = x;
        return x;
    }

    ListNode<T> insertAsSucc(T e) {
        ListNode<T> x = new ListNode<>(e, this, succ);
        succ.pred = x;
        succ = x;
        return x;
    }

}
