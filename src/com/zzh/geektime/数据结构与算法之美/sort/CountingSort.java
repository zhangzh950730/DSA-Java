package com.zzh.geektime.数据结构与算法之美.sort;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

/**
 * @author zhangzhihao
 * @date 2020/6/22 16:03
 */
public class CountingSort {

    public static void countingSort(int[] nums) {
        // 计算数组元素的区间
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }

        // 计数数组,记录每个元素出现的次数
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num] = count[num] + 1;
        }
        // 依次累加
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        // 存放排序后的结果
        int[] sorted = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int cNum = count[num];
            sorted[cNum - 1] = num;
            count[num] = cNum - 1;
        }

        System.arraycopy(sorted, 0, nums, 0, sorted.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        countingSort(nums);
        ArrayUtils.print(nums);
    }
}
