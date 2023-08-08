package com.zzh.leetcode._301_400;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _344_reverseString {
    public static void main(String[] args) {
        _344_reverseString reverseString = new _344_reverseString();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(s);
        Assert.assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, s);
    }

    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }

    public void reverseString1(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
