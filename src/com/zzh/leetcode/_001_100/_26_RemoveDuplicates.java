package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _26_RemoveDuplicates {
    public static void main(String[] args) {
        _26_RemoveDuplicates removeDuplicates_26 = new _26_RemoveDuplicates();
        int[] nums = {1, 1, 2};
        int k = removeDuplicates_26.removeDuplicates(nums);
        Assert.assertEquals(k, 2);
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = removeDuplicates_26.removeDuplicates(nums);
        Assert.assertEquals(k, 5);
    }

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j++]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
