package com.zzh.leetcode._1001_1100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1004_longestOnes {
    public static void main(String[] args) {
        _1004_longestOnes longestOnes = new _1004_longestOnes();
        int ans = longestOnes.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        Assert.assertEquals(6, ans);
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0, ans = 0, cnt0 = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right];
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
