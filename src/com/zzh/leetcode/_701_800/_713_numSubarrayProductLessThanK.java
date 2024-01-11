package com.zzh.leetcode._701_800;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _713_numSubarrayProductLessThanK {
    public static void main(String[] args) {
        _713_numSubarrayProductLessThanK numSubarrayProductLessThanK = new _713_numSubarrayProductLessThanK();
        int ans = numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
        Assert.assertEquals(8, ans);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0, left = 0, prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

}
