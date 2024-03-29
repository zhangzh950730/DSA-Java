package com.zzh.algs4.chapter2.section1;

import com.zzh.algs4.chapter2.section1.Insertion;
import com.zzh.algs4.chapter2.section1.Selection;
import com.zzh.algs4.std.StdOut;
import com.zzh.algs4.std.StdRandom;
import com.zzh.algs4.std.Stopwatch;

/**
 * @author ZhangZhiHao
 * @date 2021/7/6 12:39
 */
public class SortCompare {


    private static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Selection")) {
            Selection.sort(a);
        }
        if (alg.equals("Insertion")) {
            Insertion.sort(a);
        }
        return timer.elapsedTime();
    }

    private static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
