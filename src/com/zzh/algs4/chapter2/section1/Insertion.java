package com.zzh.algs4.chapter2.section1;

import static com.zzh.algs4.chapter2.ComparableUtils.*;

/**
 * @author ZhangZhiHao
 * @date 2021/6/28 21:27
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] array = {5, 2, 3, 4, 1};
        sort(array);
        show(array);
    }

}
