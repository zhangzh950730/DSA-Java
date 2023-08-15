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
        int n = height.length, left = 0, right = n - 1;
        int preMax = 0, sufMax = 0, ans = 0;
        while (left <= right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                ans += preMax - height[left++];
            } else {
                ans += sufMax - height[right--];
            }
        }
        return ans;
    }

    /**
     * 前后缀
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(height[i], preMax[i - 1]);
        }
        int[] sufMax = new int[n];
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(height[i], sufMax[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return ans;
    }
}
