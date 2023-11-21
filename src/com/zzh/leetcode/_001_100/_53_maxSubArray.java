package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _53_maxSubArray {

    public static void main(String[] args) {
        _53_maxSubArray maxSubArray = new _53_maxSubArray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = maxSubArray.maxSubArray(nums);
        Assert.assertEquals(6, ans);
    }

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int minPreSum = 0, preSum = 0;
        for (int num : nums) {
            preSum += num;
            ans = Math.max(ans, preSum - minPreSum);
            minPreSum = Math.min(minPreSum, preSum);
        }
        return ans;
    }
}
