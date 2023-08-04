package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _34_searchRange {
    public static void main(String[] args) {
        _34_searchRange searchRange = new _34_searchRange();
        int[] nums, ans;
        int target;

        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 8;
        ans = searchRange.searchRange(nums, target);
        Assert.assertArrayEquals(new int[]{3, 4}, ans);

    }

    public int[] searchRange(int[] nums, int target) {
        // start为大于等于target的第一个位置
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target)
            return new int[]{-1, -1};

        // end为小于等于target的第一个位置
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    /**
     * 二分模板 左闭右开
     * 二分的四种类型
     * 1.求大于等于target的第一个位置 lowerBound(target)
     * 2.求大于target的第一个位置 lowerBound(target + 1)
     * 3.求小于target的第一个位置 lowerBound(target) -1
     * 4.求小于等于target的第一个位置 lowerBound(target + 1) -1
     *
     * @return 大于等于target的第一个位置
     */
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
