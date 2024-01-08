package com.zzh.leetcode._001_100;

import org.junit.Assert;

public class _11_maxArea {
    public static void main(String[] args) {
        _11_maxArea maxArea = new _11_maxArea();
        int ans = maxArea.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assert.assertEquals(49, ans);
    }

    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            ans = Math.max(ans, (right - left) * Math.min(leftHeight, rightHeight));
            if (leftHeight < rightHeight) left++;
            else right--;
        }
        return ans;
    }
}
