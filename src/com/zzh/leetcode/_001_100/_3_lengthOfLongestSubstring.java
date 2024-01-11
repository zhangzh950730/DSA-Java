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

        s = "pwwkew";
        ans = lengthOfLongestSubstring.lengthOfLongestSubstring(s);
        Assert.assertEquals(3, ans);

    }

    public int lengthOfLongestSubstring(String s) {
        int ans = 0, left = 0;
        char[] chars = s.toCharArray();
        boolean[] has = new boolean[128];
        for (int right = 0; right < chars.length; right++) {
            char c = chars[right];
            while (has[c]) { // 循环直到删除和c同样的字符
                has[chars[left++]] = false;
            }
            has[c] = true;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
