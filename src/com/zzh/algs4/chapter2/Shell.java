package com.zzh.algs4.chapter2;

import java.rmi.dgc.Lease;

import static com.zzh.algs4.chapter2.ComparableUtils.*;

/**
 * @author ZhangZhiHao
 * @date 2021/7/6 12:55
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = 0; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Comparable[] array = {80, 23, 19, 40, 85, 1, 18, 92, 71, 8, 94, 46, 12};
        sort(array);
        print(array);
    }
}
