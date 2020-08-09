package com.zzh.数据结构_邓俊辉.chapter11_串;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;
import kotlin.Pair;

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
        int m = P.length, j = 0;
        Integer[] N = new Integer[m];
        int t = N[0] = -1;
        while (j < m - 1) {
            if (0 > t || P[j] == P[t]) {
                N[++j] = ++t;
            } else {
                t = N[t];
            }
        }
        return N;
    }

}
