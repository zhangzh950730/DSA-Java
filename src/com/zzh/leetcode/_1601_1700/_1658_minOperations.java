package com.zzh.leetcode._1601_1700;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1658_minOperations {
    public static void main(String[] args) {
        _1658_minOperations minOperations = new _1658_minOperations();
        int ans = minOperations.minOperations(new int[]{1, 1, 4, 2, 3}, 5);
        Assert.assertEquals(2, ans);
    }

    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num;
        if (target < 0) return -1;
        int ans = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum > target) sum -= nums[left++];
            if (sum == target) ans = Math.max(ans, right - left + 1);
        }
        return ans < 0 ? -1 : n - ans;
    }

}
