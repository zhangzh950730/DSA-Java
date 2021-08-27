package com.zzh.leetcode;

import java.util.Arrays;

/**
 * 多数元素
 *
 * @author zhangzhihao
 * @date 2020/6/2 9:46
 */
public class MajorityElement_169 {

    /**
     * 排序,众数必然是中位数
     */
    static class Solution1 {
        public static int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }

        public static void main(String[] args) {
            int i = majorityElement(new int[]{3, 2, 3});
            assert i == 3;
            i = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
            assert i == 2;
        }
    }

    /**
     * 分治,父串中的众数至少也是二分子串中一部分的众数
     */
    static class Solution2 {
        public static int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length - 1);
        }

        private static int majorityElementRec(int[] nums, int lo, int hi) {
            if (lo == hi) {
                return nums[lo];
            }
            int mid = (hi - lo) / 2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid + 1, hi);
            if (left == right) {
                return left;
            }
            int leftCount = countInRange(nums, left, lo, hi);
            int rightCount = countInRange(nums, right, lo, hi);
            return leftCount >= rightCount ? left : right;
        }

        private static int countInRange(int[] nums, int num, int lo, int hi) {
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        public static void main(String[] args) {
            int i = majorityElement(new int[]{3, 2, 3});
            assert i == 3;
            i = majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
            assert i == 2;
        }
    }
}
