package com.zzh.geektime.数据结构与算法之美.sort;

import com.zzh.util.ArrayUtils;

/**
 * @author zhangzhihao
 * @date 2020/6/21 16:50
 */
public class SelectionSort {

    public static void selectionSort(Integer[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            ArrayUtils.swap(nums, i, min);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 5, 6, 3, 2, 1};
        selectionSort(nums);
        ArrayUtils.print(nums);
    }
}
