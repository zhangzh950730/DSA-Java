package com.zzh.数据结构_邓俊辉.chapter12_排序;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

import java.lang.annotation.ElementType;
import java.util.Random;

/**
 * @author zhangzhihao
 * @date 2020/8/11 14:08
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] nums = {6, 3, 8, 2, 5, 9, 4, 5, 1, 7};
        quickSort(nums, 0, nums.length);
        ArrayUtils.print(nums);
    }

    public static void quickSort(Integer[] nums, int lo, int hi) {
        if (hi - lo < 2) {
            return;
        }
        int mi = partition2(nums, lo, hi);
        quickSort(nums, lo, mi);
        quickSort(nums, mi + 1, hi);
    }

    private static int partition1(Integer[] nums, int lo, int hi) {
        ArrayUtils.swap(nums, lo, lo + new Random().nextInt(Integer.MAX_VALUE) % (hi - lo));
        hi--;
        Integer pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && pivot <= nums[hi]) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    private static int partition2(Integer[] nums, int lo, int hi) {
        ArrayUtils.swap(nums, lo, lo + new Random().nextInt(Integer.MAX_VALUE) % (hi - lo));
        Integer pivot = nums[lo];
        int mi = lo;
        for (int k = lo + 1; k < hi; k++) {
            if (nums[k] < pivot) {
                ArrayUtils.swap(nums, ++mi, k);
            }
        }
        ArrayUtils.swap(nums, lo, mi);
        return mi;
    }
}
