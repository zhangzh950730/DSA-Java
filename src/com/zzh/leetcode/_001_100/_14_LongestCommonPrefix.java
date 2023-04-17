package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _14_LongestCommonPrefix {
    public static void main(String[] args) {
        _14_LongestCommonPrefix _14LongestCommonPrefix = new _14_LongestCommonPrefix();
        String prefix = _14LongestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assert.assertEquals(prefix, "fl");
        prefix = _14LongestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        Assert.assertEquals(prefix, "");
        prefix = _14LongestCommonPrefix.longestCommonPrefix(new String[]{"ab", "a"});
        Assert.assertEquals(prefix, "a");
        prefix = _14LongestCommonPrefix.longestCommonPrefix(new String[]{"a"});
        Assert.assertEquals(prefix, "a");
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String str1 = strs[0];
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return str1.substring(0, i);
                }
            }
        }
        return str1;
    }
}
