package com.zzh.leetcode._101_200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _125_isPalindrome {
    public static void main(String[] args) {
        _125_isPalindrome isPalindrome = new _125_isPalindrome();
        String s;
        boolean ans;

        s = "A man, a plan, a canal: Panama";
        ans = isPalindrome.isPalindrome(s);
        Assert.assertTrue(ans);

        s = "race a car";
        ans = isPalindrome.isPalindrome(s);
        Assert.assertFalse(ans);

        s = " ";
        ans = isPalindrome.isPalindrome(s);
        Assert.assertTrue(ans);

        s = ".,";
        ans = isPalindrome.isPalindrome(s);
        Assert.assertTrue(ans);

    }

    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char lowChar = s.charAt(low);
            while (!Character.isLetterOrDigit(lowChar) && low < high) {
                lowChar = s.charAt(++low);
            }
            lowChar = Character.toLowerCase(lowChar);

            char highChar = s.charAt(high);
            while (!Character.isLetterOrDigit(highChar) && low < high) {
                highChar = s.charAt(--high);
            }
            highChar = Character.toLowerCase(highChar);
            if (lowChar != highChar) return false;
            low++;
            high--;
        }
        return true;
    }

}
