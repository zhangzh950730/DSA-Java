package com.zzh.leetcode._101_200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _154_findMin {

    public static void main(String[] args) {
        _154_findMin findMin = new _154_findMin();
        int ans = findMin.findMin(new int[]{1, 3, 5});
        Assert.assertEquals(1, ans);
    }

    public int findMin(int[] nums) {
        int left = -1, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else if (nums[mid] > nums[right]) left = mid;
            else right--;
        }
        return nums[right];
    }
}
