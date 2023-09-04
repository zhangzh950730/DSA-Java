package com.zzh.leetcode._101_200;

import org.junit.Assert;

public class _167_twoSum {
    public static void main(String[] args) {
        _167_twoSum twoSum = new _167_twoSum();
        int[] numbers, ans;
        int target;

        numbers = new int[]{2, 7, 11, 15};
        target = 9;
        ans = twoSum.twoSum(numbers, target);
        Assert.assertArrayEquals(new int[]{1, 2}, ans);


    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int num = numbers[left] + numbers[right];
            if (num == target) break;
            else if (num < target) left++;
            else right--;
        }
        return new int[]{left + 1, right + 1};
    }
}
