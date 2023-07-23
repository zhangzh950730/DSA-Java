package com.zzh.数据结构_邓俊辉.chapter1_绪论.XC_动态规划;

import java.util.Arrays;

/**
 * 斐波那契数列
 *
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 14:54
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 43;

        long start = System.currentTimeMillis();
        fibonacci1(n);
        System.out.println("fibonacci1 " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        fibonacci2(n);
        System.out.println("fibonacci2 " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        fibonacci3(n);
        System.out.println("fibonacci3 " + (System.currentTimeMillis() - start));
    }

    private static void fibonacci3(int n) {
        for (int i = 0; i < n; i++) {
            int fib = fibonacci3_0(i);
            System.out.println("fib" + i + " = " + fib);
        }
    }

    /**
     * 动态规划 循环
     */
    private static int fibonacci3_0(int n) {
        if (n < 2) {
            return n;
        }
        int f = 0, g = 1;
        while (n-- > 0) {
            g = g + f;
            f = g - f;
        }
        return g;
    }

    /**
     * 递归 记忆表
     */
    private static void fibonacci2(int n) {
        int[] memoizationTable = new int[n];
        Arrays.fill(memoizationTable, -1);
        memoizationTable[0] = 0;
        memoizationTable[1] = 1;
        for (int i = 0; i < n; i++) {
            int fib = fibonacci2_0(i, memoizationTable);
            System.out.println("fib" + i + " = " + fib);
        }
    }

    private static int fibonacci2_0(int n, int[] memoizationTable) {
        if (n < 2) {
            return n;
        }
        if (memoizationTable[n] > 0) {
            return memoizationTable[n];
        }
        int fib = fibonacci2_0(n - 1, memoizationTable) + fibonacci2_0(n - 2, memoizationTable);
        memoizationTable[n] = fib;
        return fib;
    }

    @Deprecated
    private static void fibonacci1(int n) {
        for (int i = 0; i < n; i++) {
            int fib = fibonacci1_0(i);
            System.out.println("fib" + i + " = " + fib);
        }
    }

    private static int fibonacci1_0(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci1_0(n - 1) + fibonacci1_0(n - 2);
    }
}
