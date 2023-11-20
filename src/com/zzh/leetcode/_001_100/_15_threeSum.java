package com.zzh.leetcode._001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_threeSum {
    public static void main(String[] args) {
        _15_threeSum threeSum = new _15_threeSum();
        int[] nums;
        List<List<Integer>> ans;

        nums = new int[]{-1, 0, 1, 2, -1, -4};
        ans = threeSum.threeSum(nums);
        System.out.println("ans = " + ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue;
            if (x + nums[i + 1] + nums[i + 2] > 0) break;
            if (x + nums[nums.length - 1] + nums[nums.length - 2] < 0) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s < 0) {
                    j++;
                } else if (s > 0) {
                    k--;
                } else {
                    list.add(List.of(x, nums[j], nums[k]));
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                }
            }
        }
        return list;
    }
}
