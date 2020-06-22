package com.zzh.geektime.数据结构与算法之美.search;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/22 21:27
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {8, 11, 19, 23, 27, 33, 45, 55, 67, 98};
        int index = binarySearchIter(nums, 55);
        System.out.println("index = " + index);
        index = binarySearchRecursion(nums, 55);
        System.out.println("index = " + index);


    }

    public static int binarySearchIter(int[] nums, int value) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < value) {
                lo = mid + 1;
            } else if (value < nums[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearchRecursion(int[] nums, int value) {
        return binarySearchRecursion0(nums, 0, nums.length - 1, value);
    }

    private static int binarySearchRecursion0(int[] nums, int lo, int hi, int value) {
        if (lo > hi) {
            return -1;
        }

        int mid = lo + ((hi - lo) >> 1);
        if (nums[mid] < value) {
            return binarySearchRecursion0(nums, mid + 1, hi, value);
        } else if (value < nums[mid]) {
            return binarySearchRecursion0(nums, lo, mid - 1, value);
        } else {
            return mid;
        }
    }


}
