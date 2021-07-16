package com.zzh.algs4.chapter2.section4;

import static com.zzh.algs4.chapter2.ComparableUtils.*;
import static com.zzh.algs4.chapter2.ComparableUtils.show;

/**
 * @author ZhangZhiHao
 * @date 2021/7/14 15:58
 */
public class Heap {

    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        // 堆构造
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        // 堆排序
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a[j], a[j + 1])) j++;
            if (!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Character[] chars = new Character[]{null, 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        show(chars);
        sort(chars);
        show(chars);
    }
}
