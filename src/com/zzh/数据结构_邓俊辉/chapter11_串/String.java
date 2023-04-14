package com.zzh.数据结构_邓俊辉.chapter11_串;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;
import kotlin.Pair;

import java.util.Arrays;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/8/8 11:29
 */
public class String {
    private char[] data;
    private int _length;

    public int length() {
        return _length;
    }

    public char charAt(int i) {
        return 'a';
    }

    public String substr(int i, int k) {
        return null;
    }

    public String prefix(int k) {
        return null;
    }

    public String suffix(int k) {
        return null;
    }

    public String concat(String s) {
        return null;
    }

    public boolean equals(String s) {
        return false;
    }

    public int indexOf(char p) {
        return -1;
    }

    public int kmpMatch(char[] P, char[] T) {
        Integer[] next = buildNext(P);
        int n = P.length, i = 0;
        int m = P.length, j = 0;
        while (j < m && i < n) {
            if (0 > j || T[i] == P[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return i - j;
    }

    public static Integer[] buildNext(char[] P) {
        int m = P.length, j = 0; //"主"串指针
        Integer[] N = new Integer[m]; //next表
        int t = N[0] = -1; //模式串指针 (P[-1]通配符)
        while (j < m - 1) {
            System.out.println("一次循环开始===============");
            System.out.println("t = " + t);
            System.out.println("j = " + j);
            if (0 > t || P[j] == P[t]) { //匹配
                System.out.println("匹配");
                N[++j] = ++t;
                System.out.println("t自增 = " + t);
                System.out.println("j自增 = " + j);
                ArrayUtils.print(N);
            } else { //失配
                System.out.println("失配");
                t = N[t];
                System.out.println("t = N[t] = " + t);
            }
            System.out.println("一次循环结束===============");
        }
        return N;
    }

    public static Integer[] buildBC(char[] P) {
        Integer[] bc = new Integer[256];
        Arrays.fill(bc, -1);
        for (int i = 0; i < bc.length; i++) {
            bc[P[i]] = i;
        }
        return bc;
    }

}
