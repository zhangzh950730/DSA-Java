package com.zzh.数据结构_邓俊辉.chapter10_优先级队列;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;
import com.zzh.数据结构_邓俊辉.chapter2_向量.OrderedVector;

/**
 * 完全二叉堆
 *
 * @author zhangzhihao
 * @date 2020/8/6 13:47
 */
public class PQ_ComplHeap extends OrderedVector implements PriorityQueue<Integer> {

    /**
     * 下滤
     */
    protected int percolateDown(int n, int i) {
        int j;
        while (i != (j = properParent((Integer[]) elements, n, i))) {
            ArrayUtils.swap(elements, i, j);
            i = j;
        }
        return i;
    }

    private int properParent(Integer[] elements, int n, int i) {
        return rChildValid(i) ? bigger(elements, i, lChild(i)) : lChildValid(i) ? bigger(elements, i, rChild(i)) : i;
    }

    private Integer bigger(Integer[] elements, int i, int j) {
        return elements[i] < elements[j] ? elements[j] : elements[i];
    }

    /**
     * 上滤
     */
    protected int percolateUp(int i) {
        while (parentValid(i)) {
            int j = parent(i);
            if (elementData(i) < elementData(j)) {
                break;
            }
            ArrayUtils.swap(elements, i, j);
            i = j;
        }
        return i;
    }

    private boolean parentValid(int i) {
        return parent(i) > 0;
    }

    private boolean lChildValid(int i) {
        return lChild(i) > 0;
    }

    private boolean rChildValid(int i) {
        return rChild(i) > 0;
    }

    /**
     * Floyd建堆算法
     */
    protected void heapify(int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            percolateDown(n, i);
        }
    }

    public PQ_ComplHeap(Integer[] array, int n) {
        super(array, 0, n);
        heapify(n);
    }

    @Override
    public void insert(Integer e) {
        insert(size - 1, e);
        percolateUp(size - 1);
    }

    @Override
    public Integer getMax() {
        return null;
    }

    @Override
    public Integer delMax() {
        Integer maxElem = elementData(0);
        elements[0] = elementData(--size);
        percolateDown(size, 0);
        return maxElem;
    }

    public int parent(int i) {
        return (i - 1) >> 1;
    }

    public int lChild(int i) {
        return 1 + (i << 1);
    }

    public int rChild(int i) {
        return (1 + i) << 1;
    }
}
