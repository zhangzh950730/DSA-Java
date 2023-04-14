package com.zzh.数据结构_邓俊辉.chapter1_绪论.XC_动态规划;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

/**
 * 求两个字符串的最长公共子序列的长度
 *
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 16:28
 */
public class LCS {

    public static void main(String[] args) {
        int lcs = lcs("program", "algorithm");
        System.out.println("lcs = " + lcs);
        lcs = lcs("didactical", "advantage");
        System.out.println("lcs = " + lcs);
    }

    public static int lcs(String s1, String s2) {
        Integer[][] table = new Integer[s2.length() + 1][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    table[j + 1][i + 1] = table[j][i] + 1;
                } else {
                    table[j + 1][i + 1] = Math.max(table[j][i + 1], table[j + 1][i]);
                }
            }
        }
        for (Integer[] array : table) {
            ArrayUtils.print(array);
        }
        return table[s2.length()][s1.length()];
    }
}
