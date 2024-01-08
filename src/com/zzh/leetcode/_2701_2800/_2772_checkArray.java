package com.zzh.leetcode._2701_2800;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2772_checkArray {
    public static void main(String[] args) {
        _2772_checkArray checkArray = new _2772_checkArray();
        int[] nums = new int[]{2, 2, 3, 1, 1, 0};
        boolean ans = checkArray.checkArray(nums, 3);
        Assert.assertTrue(ans);
    }

    public boolean checkArray(int[] nums, int k) {
        int n = nums.length, sumD = 0;
        var d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sumD += d[i];
            int x = nums[i];
            x += sumD;
            if (x == 0) continue; // 无需操作
            if (x < 0 || i + k > n) return false; // 无法操作
            sumD -= x; // 直接加到 sumD 中
            d[i + k] += x;
        }
        return true;
    }

}
