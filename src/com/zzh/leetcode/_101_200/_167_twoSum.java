package com.zzh.leetcode._101_200;

public class _167_twoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) break;
            else if (sum > target) right--;
            else left++;
        }
        return new int[]{left + 1, right + 1};
    }
}
