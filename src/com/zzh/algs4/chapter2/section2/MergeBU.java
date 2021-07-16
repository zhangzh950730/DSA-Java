package com.zzh.algs4.chapter2.section2;

import static com.zzh.algs4.chapter2.ComparableUtils.less;
import static com.zzh.algs4.chapter2.ComparableUtils.show;

/**
 * 自底向上的归并排序
 *
 * @author ZhangZhiHao
 * @date 2021/7/13 9:01
 */
public class MergeBU {
    private static Comparable[] aux;

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        System.out.println("before merge");
        System.out.println("lo = " + lo);
        System.out.println("mid = " + mid);
        System.out.println("hi = " + hi);
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
        System.out.println("after merge");
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            System.out.println("sz = " + sz);
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void main(String[] args) {
        Character[] chars = new Character[]{'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
        show(chars);
        sort(chars);
        show(chars);
    }
}
