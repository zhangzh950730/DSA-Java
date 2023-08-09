package com.zzh.leetcode._000_模板;

/**
 * 二分的四种类型
 * 1.求大于等于target的第一个位置 lowerBound(target)
 * 2.求大于target的第一个位置 lowerBound(target + 1)
 * 3.求小于target的第一个位置 lowerBound(target) -1
 * 4.求小于等于target的第一个位置 lowerBound(target + 1) -1
 *
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class BinarySearch {

    /**
     * 二分模板 左闭右开
     *
     * @return 大于等于target的第一个位置
     */
    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    /**
     * 二分模板 左闭右闭
     *
     * @return 大于等于target的第一个位置
     */
    private int lowerBound1(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

}
