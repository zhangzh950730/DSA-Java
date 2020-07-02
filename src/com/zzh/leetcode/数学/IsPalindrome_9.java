package com.zzh.leetcode.数学;

/**
 * @author zhangzhihao
 * @date 2020/6/10 12:38
 */
public class IsPalindrome_9 {
    public static void main(String[] args) {
        boolean palindrome = Solution.isPalindrome(12321);
        System.out.println(palindrome);
        palindrome = Solution.isPalindrome(12345);
        System.out.println(palindrome);
    }

    static class Solution {
        public static boolean isPalindrome(int x) {
            if (x < 0 || (x != 0 && x % 10 == 0)) {
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x = x / 10;
            }
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }
}
