package com.zzh.leetcode._001_100;

public class _11_maxArea {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, ans = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return ans;
    }
}
