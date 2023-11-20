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
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int condition = numbers[lo] + numbers[hi];
            if (condition == target) break;
            else if (condition < target) lo++;
            else hi--;
        }
        return new int[]{lo + 1, hi + 1};
    }
}
