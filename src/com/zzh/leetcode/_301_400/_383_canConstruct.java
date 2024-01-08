package com.zzh.leetcode._301_400;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _383_canConstruct {
    public static void main(String[] args) {
        _383_canConstruct canConstruct = new _383_canConstruct();
        boolean ans = canConstruct.canConstruct("aa", "aab");
        Assert.assertTrue(ans);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] table = new int[26];
        for (char c : magazine.toCharArray()) {
            table[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            int cnt = --table[c - 'a'];
            if (cnt < 0) return false;
        }
        return true;
    }
}
