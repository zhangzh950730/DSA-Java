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
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 排序后的数组, 第一个数字大于0, 则三个数的和必大于0
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 相同数字的去重处理
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) j++;
                else if (sum > 0) k--;
                else {
                    // 加入当前结果
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    // 还需继续计算其他可能的结果, 但要先去重相同值
                    do j++; while (j < k && nums[j] == nums[j - 1]);
                    do k--; while (j < k && nums[k] == nums[k + 1]);
                }
            }
        }
        return ans;
    }
}
