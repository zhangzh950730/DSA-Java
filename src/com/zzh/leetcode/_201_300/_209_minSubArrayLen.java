package com.zzh.leetcode._201_300;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _209_minSubArrayLen {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = n + 1, left = 0, s = 0;
        for (int right = 0; right < nums.length; right++) {
            s += nums[right];
            while (s >= target) {
                ans = Math.min(ans, right - left + 1);
                s -= nums[left++];
            }
        }
        return ans > n ? 0 : ans;
    }
}
