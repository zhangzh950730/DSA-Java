package com.zzh.leetcode._001_100;

import com.zzh.util.ArrayUtils;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _75_SortColors {

    public static void main(String[] args) {
        _75_SortColors sortColors = new _75_SortColors();
        int[] nums;

        nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors.sortColors(nums);
        ArrayUtils.print(nums);

        nums = new int[]{2, 0, 1};
        sortColors.sortColors(nums);
        ArrayUtils.print(nums);
    }

    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
