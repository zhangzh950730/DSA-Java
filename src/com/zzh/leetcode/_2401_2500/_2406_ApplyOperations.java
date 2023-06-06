package com.zzh.leetcode._2401_2500;

import com.zzh.util.ArrayUtils;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2406_ApplyOperations {
    public static void main(String[] args) {
        _2406_ApplyOperations applyOperations = new _2406_ApplyOperations();
        int[] nums;
        int[] ans;

        nums = new int[]{1, 2, 2, 1, 1, 0};
        ans = applyOperations.applyOperations(nums);
        ArrayUtils.print(ans);

        nums = new int[]{0, 1};
        ans = applyOperations.applyOperations(nums);
        ArrayUtils.print(ans);


    }

    public int[] applyOperations(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0) {
                swap(nums, i, j++);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
