package com.zzh.geektime.数据结构与算法之美.sort;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

import java.util.Arrays;

/**
 * @author zhangzhihao
 * @date 2020/6/22 10:45
 */
public class MergeSort {

    public static void mergeSort(Integer[] nums) {
        mergeSort0(nums, 0, nums.length - 1);
    }

    private static void mergeSort0(Integer[] nums, int min, int max) {
        if (min >= max) {
            return;
        }
        int mid = min + (max - min) / 2;
        mergeSort0(nums, min, mid);
        mergeSort0(nums, mid + 1, max);
        merge(nums, min, mid, max);
    }

    private static void merge(Integer[] nums, int min, int mid, int max) {
        int[] left = new int[mid - min + 2];
        int[] right = new int[max - mid + 1];

        for (int i = 0; i + min <= mid; i++) {
            left[i] = nums[i + min];
        }
        left[mid - min + 1] = Integer.MAX_VALUE;

        for (int i = 0; i + mid + 1 <= max; i++) {
            right[i] = nums[i + mid + 1];
        }
        right[max - mid] = Integer.MAX_VALUE;

        int j = 0, k = 0, l = min;
        while (l <= max) {
            if (left[j] < right[k]) {
                nums[l++] = left[j++];
            } else {
                nums[l++] = right[k++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {11, 8, 3, 9, 7, 1, 2, 5};
        mergeSort(nums);
        ArrayUtils.print(nums);
    }

}
