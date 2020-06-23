package com.zzh.geektime.数据结构与算法之美.array;

import java.util.Arrays;

/**
 * @author zhangzhihao
 * @date 2020/6/22 14:49
 */
public class ArrayUtils {

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        swap(nums, 2, 3);
        print(nums);
    }

}
