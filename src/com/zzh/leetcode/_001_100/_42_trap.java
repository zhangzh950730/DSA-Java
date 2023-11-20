package com.zzh.leetcode._001_100;

import org.junit.Assert;

public class _42_trap {
    public static void main(String[] args) {
        _42_trap trap = new _42_trap();
        int[] height;
        int ans;

        height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        ans = trap.trap(height);
        Assert.assertEquals(6, ans);
    }

    /**
     * 双指针
     */
    public int trap(int[] height) {
        int preMax = 0, sufMax = 0;
        int ans = 0;
        int lo = 0, hi = height.length - 1;
        while (lo <= hi) {
            preMax = Math.max(preMax, height[lo]);
            sufMax = Math.max(sufMax, height[hi]);
            if (preMax < sufMax) {
                ans += preMax - height[lo++];
            } else {
                ans += sufMax - height[hi--];
            }
        }
        return ans;
    }

    /**
     * 前后缀
     */
    public int trap1(int[] height) {
        int length = height.length;
        int[] preMax = new int[length];
        for (int i = 0; i < preMax.length; i++) {
            if (i == 0) preMax[i] = height[i];
            else preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        int[] sufMax = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) sufMax[i] = height[i];
            else sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return ans;
    }
}
