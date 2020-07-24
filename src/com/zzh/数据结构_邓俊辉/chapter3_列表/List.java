package com.zzh.数据结构_邓俊辉.chapter3_列表;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/23 20:37
 * <p>
 * 列表类
 */
public class List<T> {
    /**
     * 规模
     */
    protected int _size;

    /**
     * 头尾 哨兵
     */
    protected ListNode<T> header, trailer;

    public void init() {
        // 创建头尾哨兵
        header = new ListNode<>();
        trailer = new ListNode<>();
        // 头尾哨兵互联
        header.pred = null;
        header.succ = trailer;
        trailer.pred = header;
        trailer.succ = null;
        // 记录规模
        _size = 0;
    }

    public ListNode<T> find(T e, int n, ListNode<T> p) {
        while (0 < n--) {
            if (e == p.data) {
                return p;
            } else {
                p = p.succ;
            }
        }
        return null;
    }

    public ListNode<T> insertBefore(ListNode<T> p, T e) {
        _size++;
        return p.insertAsPred(e);
    }

    public ListNode<T> insertAfter(ListNode<T> p, T e) {
        _size++;
        return p.insertAsSucc(e);
    }

    public void copyNodes(ListNode<T> p, int n) {
        init();
        while (0 < n--) {
            insertAsLast(p.data);
            p = p.succ;
        }
    }

    public void insertAsLast(T e) {
        insertBefore(trailer, e);
    }

    public T remove(ListNode<T> p) {
        T e = p.data;
        p.pred.succ = p.succ;
        p.succ.pred = p.pred;
        _size--;
        return e;
    }

    public void removeAll() {
        clear();
        header = null;
        trailer = null;
    }

    public int clear() {
        int oldSize = _size;
        while (0 < _size) {
            remove(header.succ);
        }
        return oldSize;
    }

    /**
     * 无序列表 唯一化
     */
    public int deduplicate() {
        int oldSize = _size;
        ListNode<T> p = first();
        for (int i = 0; p != trailer; p = p.succ) {
            ListNode<T> q = find(p.data, i, p);
            if (q != null) {
                remove(q);
            } else {
                i++;
            }
        }
        return oldSize - _size;
    }

    public ListNode<T> first() {
        return header.succ;
    }


    public static void main(String[] args) {

    }
}
