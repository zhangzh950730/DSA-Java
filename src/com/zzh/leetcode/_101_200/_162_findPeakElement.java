package com.zzh.leetcode._101_200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _162_findPeakElement {
    public static void main(String[] args) {
        _162_findPeakElement findPeakElement = new _162_findPeakElement();
        int[] nums;
        int ans;

        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        ans = findPeakElement.findPeakElement(nums);
        Assert.assertEquals(5, ans);
    }

    public int findPeakElement(int[] nums) {
        int left = -1, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) right = mid;
            else left = mid;
        }
        return right;
    }
}
