package com.zzh.leetcode._001_100;

public class _11_maxArea {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int ans = 0, lo = 0, hi = height.length - 1;
        while (lo < hi) {
            int area = (hi - lo) * Math.min(height[lo], height[hi]);
            ans = Math.max(ans, area);
            if (height[lo] < height[hi]) lo++;
            else hi--;
        }
        return ans;
    }
}
