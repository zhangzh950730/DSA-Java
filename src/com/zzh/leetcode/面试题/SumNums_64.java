package com.zzh.leetcode.面试题;

import com.zzh.Assert;

/**
 * 面试题64. 求1+2+…+n
 *
 * @author zhangzhihao
 * @date 2020/6/2 10:29
 */
public class SumNums_64 {

    /**
     * 递归,通过逻辑与短路
     */
    static class Solution {
        public static int sumNums(int n) {
            boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
            return n;
        }

        public static void main(String[] args) {
            int i = sumNums(3);
            Assert.equals(i, 6);

            i = sumNums(9);
            Assert.equals(i, 45);

            i = sumNums(2);
            Assert.equals(i, 3);
        }
    }
}