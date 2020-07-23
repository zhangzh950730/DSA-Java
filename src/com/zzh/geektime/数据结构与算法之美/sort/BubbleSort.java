package com.zzh.geektime.数据结构与算法之美.sort;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @author zhangzhihao
 * @date 2020/6/21 14:17
 */
public class BubbleSort {

    public static void bubbleSort(Integer[] nums) {
        if (nums.length <= 1) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    ArrayUtils.swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 5, 4, 1, 2, 6};
        BubbleSort.bubbleSort(nums);
        ArrayUtils.print(nums);
    }
}
