package com.zzh.leetcode._401_500;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _409_longestPalindrome {
    public static void main(String[] args) {
        _409_longestPalindrome longestPalindrome = new _409_longestPalindrome();
        String s;
        int ans;

        s = "abccccdd";
        ans = longestPalindrome.longestPalindrome(s);
        Assert.assertEquals(7, ans);

        s = "a";
        ans = longestPalindrome.longestPalindrome(s);
        Assert.assertEquals(1, ans);

        s = "aaaaaccc";
        ans = longestPalindrome.longestPalindrome(s);
        Assert.assertEquals(7, ans);

    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, Integer::sum);
        }
        int ans = 0, odd = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            Integer count = entry.getValue();
            int rem = count % 2;
            ans += count - rem;
            if (rem == 1) odd = 1;
        }
        return ans + odd;
    }

}
