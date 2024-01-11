package com.zzh.leetcode._2901_3000;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2962_countSubarrays {
    public static void main(String[] args) {
        _2962_countSubarrays countSubarrays = new _2962_countSubarrays();
        long ans = countSubarrays.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2);
        Assert.assertEquals(ans, 6);
    }

    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        for (int num : nums) max = Math.max(max, num);
        long ans = 0;
        int left = 0, cntMx = 0;
        for (int num : nums) {
            if (num == max) cntMx++;
            while (cntMx == k) {
                if (nums[left++] == max) cntMx--;
            }
            ans += left;
        }
        return ans;
    }

}
