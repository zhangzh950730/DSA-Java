package com.zzh.数据结构_邓俊辉.chapter2_向量;

import kotlin.random.RandomKt;

import java.util.Random;

/**
 * @author zhangzhihao
 * @date 2020/7/19 14:30
 */
public class OrderedVector<T> extends Vector<T> {

    public OrderedVector(T[] array, int lo, int hi) {
        super(array, lo, hi);
    }

    public int uniquify() {
        int i = 0, j = 0;
        while (++j < size) {
            if (elements[i] != elements[j]) {
                elements[++i] = elements[j];
            }
        }
        var old = size;
        size = i + 1;
        shrink();
        return old - size;
    }

    public int search(T e, int lo, int hi) {
        return (new Random().nextInt() % 2 == 0) ? binSearch(e, lo, hi) : fibSearch(e, lo, hi);
    }

    private int fibSearch(T e, int lo, int hi) {
        return 0;
    }

    private int binSearch(T e, int lo, int hi) {
        return 0;
    }

    public static void main(String[] args) {
        Integer[] array = {3, 3, 3, 3, 5, 5, 5, 5, 5, 8, 8, 8, 13, 13, 13, 13};
        var orderedVector = new OrderedVector<>(array, 0, array.length);
        System.out.println(orderedVector);

        int uniquify = orderedVector.uniquify();
        System.out.println(orderedVector);
        System.out.println("uniquify = " + uniquify);
    }
}
