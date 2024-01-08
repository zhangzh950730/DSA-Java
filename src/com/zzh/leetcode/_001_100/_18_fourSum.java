package com.zzh.leetcode._001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _18_fourSum {
    public static void main(String[] args) {
        _18_fourSum fourSum = new _18_fourSum();
        List<List<Integer>> ans = fourSum.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        System.out.println("ans = " + ans);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            long x = nums[a];
            if (a > 0 && x == nums[a - 1]) continue; // 跳过重复
            if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break;
            if (x + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
            for (int b = a + 1; b < n - 2; b++) {
                int y = nums[b];
                if (b > a + 1 && y == nums[b - 1]) continue; // 跳过重复
                if (x + y + nums[b + 1] + nums[b + 2] > target) break;
                if (x + y + nums[n - 2] + nums[n - 1] < target) continue;
                int c = b + 1, d = n - 1;
                while (c < d) {
                    long sum = x + y + nums[c] + nums[d];
                    if (sum < target) c++;
                    else if (sum > target) d--;
                    else {
                        ans.add(List.of((int) x, y, nums[c], nums[d]));
                        do c++; while (c < d && nums[c] == nums[c - 1]);
                        do d--; while (c < d && nums[d] == nums[d + 1]);
                    }
                }
            }
        }
        return ans;
    }

}
