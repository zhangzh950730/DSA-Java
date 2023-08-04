package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _33_search {
    public static void main(String[] args) {
        _33_search search = new _33_search();
        int[] nums;
        int target, ans;

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 0;
        ans = search.search(nums, target);
        Assert.assertEquals(4, ans);

    }

    public int search(int[] nums, int target) {
        int left = -1, right = nums.length, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;

            boolean isBlue;
            int end = nums[nums.length - 1];
            if (nums[mid] > end) {
                isBlue = target > end && nums[mid] >= target;
            } else {
                isBlue = target > end || nums[mid] >= target;
            }

            if (isBlue) right = mid;
            else left = mid;
        }
        if (right == nums.length || nums[right] != target) return -1;
        return right;
    }

}
