package com.zzh.leetcode._101_200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _198_rob {
    public static void main(String[] args) {
        _198_rob rob = new _198_rob();
        int[] nums;
        int ans;

        nums = new int[]{1, 2, 3, 1};
        ans = rob.rob(nums);
        Assert.assertEquals(4, ans);

        nums = new int[]{2, 7, 9, 3, 1};
        ans = rob.rob(nums);
        Assert.assertEquals(12, ans);
    }

    /**
     * 滚动变量
     */
    public int rob(int[] nums) {
        int first = 0, second = 0;
        for (int num : nums) {
            int temp = second;
            second = Math.max(first + num, second);
            first = temp;
        }
        return second;
    }

    /**
     * 数组存储
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

}
