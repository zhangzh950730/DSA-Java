package com.zzh.leetcode.竞赛.周赛._376;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2_divideArray {
    public static void main(String[] args) {
        _2_divideArray divideArray = new _2_divideArray();

        int[] nums = new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1};
        int[][] ans = divideArray.divideArray(nums, 2);
        System.out.println("ans = " + ans);
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 2; i < nums.length; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new int[][]{};
            }
            ans[i / 3] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
        }
        return ans;
    }
}
