package com.zzh.geektime.数据结构与算法之美.search;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/22 22:18
 */
public class VarietasBinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        int index = binarySearchFirst(nums, 8);
        System.out.println("index = " + index);
        index = binarySearchLast(nums, 8);
        System.out.println("index = " + index);

        int[] nums1 = new int[]{3, 4, 6, 7, 10};
        index = binarySearchFirst大于等于(nums1, 5);
        System.out.println("index = " + index);

        int[] nums2 = new int[]{3, 5, 6, 8, 9, 10};
        index = binarySearchLast小于等于(nums2, 7);
        System.out.println("index = " + index);

    }

    /**
     * 查找第一个值等于给定值的元素
     */
    public static int binarySearchFirst(int[] nums, int value) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < value) {
                lo = mid + 1;
            } else if (value < nums[mid]) {
                hi = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != value) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     */
    public static int binarySearchLast(int[] nums, int value) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < value) {
                lo = mid + 1;
            } else if (value < nums[mid]) {
                hi = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != value) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     */
    public static int binarySearchFirst大于等于(int[] nums, int value) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] >= value) {
                if (mid == 0 || nums[mid - 1] < value) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     */
    public static int binarySearchLast小于等于(int[] nums, int value) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] <= value) {
                if (mid == nums.length - 1 || nums[mid + 1] > value) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
