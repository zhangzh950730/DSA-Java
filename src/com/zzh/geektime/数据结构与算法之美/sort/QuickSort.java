package com.zzh.geektime.数据结构与算法之美.sort;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

import java.lang.reflect.Array;

/**
 * @author zhangzhihao
 * @date 2020/6/22 14:30
 */
public class QuickSort {

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int min, int max) {
        if (min >= max) {
            return;
        }
        int pivotIndex = partition(nums, min, max);
        quickSort(nums, min, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, max);
    }

    private static int partition(int[] nums, int min, int max) {
        int pivot = nums[max];
        int i = min;
        for (int j = min; j < max; j++) {
            if (nums[j] < pivot) {
                if (i != j) {
                    ArrayUtils.swap(nums, i, j);
                }
                i++;
            }
        }
        ArrayUtils.swap(nums, i, max);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {11, 8, 3, 9, 7, 1, 2, 5};
        quickSort(nums);
        ArrayUtils.print(nums);
    }
}
