package com.zzh.leetcode.竞赛.周赛._358;

import org.junit.Assert;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1_maxSum {
    public static void main(String[] args) {
        _1_maxSum maxSum = new _1_maxSum();
        int[] nums;
        int ans;

        nums = new int[]{84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        ans = maxSum.maxSum(nums);
        Assert.assertEquals(165, ans);

    }

    public int maxSum(int[] nums) {
        int ans = -1;
        int[] maxVal = new int[10];
        Arrays.fill(maxVal, Integer.MIN_VALUE);
        for (int num : nums) {
            int maxDigit = 0;
            for (int x = num; x > 0; x /= 10) {
                maxDigit = Math.max(maxDigit, x % 10);
            }
            ans = Math.max(ans, num + maxVal[maxDigit]);
            maxVal[maxDigit] = Math.max(num, maxVal[maxDigit]);
        }
        return ans;
    }
}
