package com.zzh.leetcode._001_100;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _16_threeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        _16_threeSumClosest threeSumClosest = new _16_threeSumClosest();
        int ans = threeSumClosest.threeSumClosest(nums, 1);
        Assert.assertEquals(2, ans);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum < target) j++;
                else if (sum > target) k--;
                else return ans;
            }
        }
        return ans;
    }

}
