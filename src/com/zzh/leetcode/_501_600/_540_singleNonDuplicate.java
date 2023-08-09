package com.zzh.leetcode._501_600;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _540_singleNonDuplicate {

    public static void main(String[] args) {
        _540_singleNonDuplicate singleNonDuplicate = new _540_singleNonDuplicate();
        int[] nums;
        int ans;

//        nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
//        ans = singleNonDuplicate.singleNonDuplicate(nums);
//        Assert.assertEquals(ans, 2);

        nums = new int[]{1, 1, 2, 3, 3};
        ans = singleNonDuplicate.singleNonDuplicate(nums);
        Assert.assertEquals(ans, 2);

    }

    /**
     * 偶数下标的二分查找
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            mid -= mid & 1; //保证mid为偶数
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else right = mid;
        }
        return nums[left];
    }

    /**
     * 全数组的二分查找
     */
    public int singleNonDuplicate1(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid ^ 1])
                left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

}
