package com.zzh.leetcode._201_300;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _209_minSubArrayLen {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, ans = n + 1, sum = 0, left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
        }
        return ans <= n ? ans : 0;
    }
}
