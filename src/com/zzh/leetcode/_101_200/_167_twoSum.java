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
        int i = 0, j = numbers.length - 1;
        while (true) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) j--;
            else if (sum < target) i++;
            else return new int[]{i + 1, j + 1};
        }
    }
}
