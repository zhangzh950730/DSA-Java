package com.zzh;

import static com.zzh.数据结构_邓俊辉.chapter11_串.String.buildNext;

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

    public static void main(String[] args) {
        final Integer[] next = buildNext(new char[]{'c', 'h', 'i', 'n', 'c', 'h', 'i', 'l', 'l', 'a'});
        System.out.println("next = " + next);
    }
}
