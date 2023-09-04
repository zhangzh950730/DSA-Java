package com.zzh.leetcode._601_700;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _647_countSubstrings {

    public static void main(String[] args) {
        _647_countSubstrings countSubstrings = new _647_countSubstrings();
        String s;
        int ans;

        s = "abc";
        ans = countSubstrings.countSubstrings(s);
        Assert.assertEquals(3, ans);

//        s = "aaa";
//        ans = countSubstrings.countSubstrings(s);
//        Assert.assertEquals(6, ans);

    }

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

}
