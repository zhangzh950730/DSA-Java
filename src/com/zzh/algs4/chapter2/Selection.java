package com.zzh.algs4.chapter2;

import static com.zzh.algs4.chapter2.ComparableUtils.*;

/**
 * @author ZhangZhiHao
 * @date 2021/6/28 21:27
 */
public class Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        Comparable[] array = {5, 2, 3, 4, 1};
        sort(array);
        print(array);
    }

}
