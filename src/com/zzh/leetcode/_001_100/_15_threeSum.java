package com.zzh.leetcode._001_100;

import com.zzh.数据结构_邓俊辉.chapter1_绪论.E_递归与迭代.Sum;

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
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int num = nums[i];
            if (i > 0 && num == nums[i - 1]) continue;
            if (num + nums[i + 1] + nums[i + 2] > 0) break;
            if (num + nums[n - 1] + nums[n - 2] < 0) continue;

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = num + nums[j] + nums[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    ans.add(Arrays.asList(num, nums[j], nums[k]));

                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
