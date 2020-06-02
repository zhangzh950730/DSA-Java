package com.zzh;

/**
 * @author zhangzhihao
 * @date 2020/6/2 10:42
 */
public abstract class Assert {
    public static void equals(int a, int b) {
        System.out.println(a == b);
    }

    public static void equals(Integer a, Integer b) {
        System.out.println(a.equals(b));
    }
}
