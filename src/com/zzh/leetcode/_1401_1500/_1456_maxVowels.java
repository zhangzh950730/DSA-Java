package com.zzh.leetcode._1401_1500;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1456_maxVowels {
    public static void main(String[] args) {
        _1456_maxVowels maxVowels = new _1456_maxVowels();
        int ans = maxVowels.maxVowels("leetcode", 3);
        Assert.assertEquals(2, ans);
    }

    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowel_count = 0;
        for (int i = 0; i < k; ++i) {
            vowel_count += isVowel(s.charAt(i));
        }
        int ans = vowel_count;
        for (int i = k; i < n; ++i) {
            vowel_count += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            ans = Math.max(ans, vowel_count);
        }
        return ans;
    }

    public int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }

}
