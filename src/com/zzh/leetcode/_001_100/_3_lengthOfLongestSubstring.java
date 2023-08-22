package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        _3_lengthOfLongestSubstring lengthOfLongestSubstring = new _3_lengthOfLongestSubstring();
        String s;
        int ans;

        s = "abcabcbb";
        ans = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        Assert.assertEquals(3, ans);

//        s = "bbbbb";
//        ans = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
//        Assert.assertEquals(1, ans);

//        s = "pwwkew";
//        ans = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
//        Assert.assertEquals(3, ans);

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0, left = 0;
        int[] cnt = new int[128];
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            ++cnt[c];
            while (cnt[c] > 1) {
                --cnt[s.charAt(left++)];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
