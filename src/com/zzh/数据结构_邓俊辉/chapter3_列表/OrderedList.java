package com.zzh.数据结构_邓俊辉.chapter3_列表;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/23 22:09
 */
public class OrderedList extends List<Integer> {

    /**
     * 有序列表 唯一化
     */
    public int uniquify() {
        if (_size < 2) {
            return 0;
        }
        int oldSize = _size;
        ListNode<Integer> p = first();
        ListNode<Integer> q;
        while (trailer != (q = p.succ)) {
            if (!p.data.equals(q.data)) {
                p = q;
            } else {
                remove(q);
            }
        }
        return oldSize - _size;
    }

    /**
     * 查找
     */
    public ListNode<Integer> search(Integer e, int n, ListNode<Integer> p) {
        do {
            p = p.pred;
            n--;
        } while (-1 < n && e < p.data);
        return p;
    }

    public void selectionSort(ListNode<Integer> p, int n) {
        ListNode<Integer> head = p.pred;
        ListNode<Integer> tail = p;
        for (int i = 0; i < n; i++) {
            tail = tail.succ;
        }
        while (1 < n--) {
            insertBefore(tail, remove(selectMax(head.succ, n)));
            tail = tail.pred;
        }
    }

    private ListNode<Integer> selectMax(ListNode<Integer> p, int n) {
        ListNode<Integer> max = p;
        for (ListNode<Integer> cur = p; 1 < n; n--) {
            if ((cur = cur.succ).data >= max.data) {
                max = cur;
            }
        }
        return max;
    }
}
