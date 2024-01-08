package com.zzh.leetcode._2601_2700;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2697_makeSmallestPalindrome {
    public static void main(String[] args) {
        _2697_makeSmallestPalindrome makeSmallestPalindrome = new _2697_makeSmallestPalindrome();

        String ans = makeSmallestPalindrome.makeSmallestPalindrome("egcfe");
        Assert.assertEquals("efcfe", ans);

        ans = makeSmallestPalindrome.makeSmallestPalindrome("abcd");
        Assert.assertEquals("abba", ans);


    }

    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char x = chars[i], y = chars[n - 1 - i];
            if (x <= y) chars[n - 1 - i] = x;
            else chars[i] = y;
        }
        return new String(chars);
    }
}
