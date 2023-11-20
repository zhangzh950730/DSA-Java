package com.zzh.leetcode._201_300;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _213_rob {
    public static void main(String[] args) {
        _213_rob rob = new _213_rob();
        int[] nums;
        int ans;

        nums = new int[]{2, 3, 2};
        ans = rob.rob(nums);
        Assert.assertEquals(3, ans);

        nums = new int[]{1, 2, 3, 1};
        ans = rob.rob(nums);
        Assert.assertEquals(4, ans);
    }

    public int rob(int[] nums) {
        int ans1 = nums[0] + rob(nums, 2, nums.length - 1);
        int ans2 = rob(nums, 1, nums.length);
        return Math.max(ans1, ans2);
    }

    /**
     * 滚动变量
     */
    public int rob(int[] nums, int lo, int hi) {
        int first = 0, second = 0;
        for (int i = lo; i < hi; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
