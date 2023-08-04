package com.zzh.leetcode._101_200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _153_findMin {
    public static void main(String[] args) {
        _153_findMin findMin = new _153_findMin();
        int[] nums;
        int ans;

        nums = new int[]{3, 4, 5, 1, 2};
        ans = findMin.findMin(nums);
        Assert.assertEquals(1, ans);

    }

    public int findMin(int[] nums) {
        int left = -1, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid;
            } else left = mid;
        }
        return nums[right];
    }
}
