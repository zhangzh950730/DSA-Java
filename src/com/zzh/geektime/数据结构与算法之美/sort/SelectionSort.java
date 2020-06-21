package com.zzh.geektime.数据结构与算法之美.sort;

/**
 * @author zhangzhihao
 * @date 2020/6/21 16:50
 */
public class SelectionSort {

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 3, 2, 1};
        selectionSort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
