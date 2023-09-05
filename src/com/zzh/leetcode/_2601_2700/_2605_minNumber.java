package com.zzh.leetcode._2601_2700;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2605_minNumber {

    public static void main(String[] args) {
        _2605_minNumber minNumber = new _2605_minNumber();
        int[] nums1, nums2;
        int ans;

        nums1 = new int[]{4, 1, 3};
        nums2 = new int[]{5, 7};
        ans = minNumber.minNumber(nums1, nums2);
        Assert.assertEquals(15, ans);

        nums1 = new int[]{3, 5, 2, 6};
        nums2 = new int[]{3, 1, 7};
        ans = minNumber.minNumber(nums1, nums2);
        Assert.assertEquals(3, ans);

    }

    public int minNumber(int[] nums1, int[] nums2) {
        int mask1 = 0, mask2 = 0;
        for (int x : nums1) {
            mask1 |= 1 << x;
        }
        for (int x : nums2) {
            mask2 |= 1 << x;
        }
        int m = mask1 & mask2;
        if (m > 0) return Integer.numberOfTrailingZeros(m); // 有交集
        int x = Integer.numberOfTrailingZeros(mask1);
        int y = Integer.numberOfTrailingZeros(mask2);
        return Math.min(x * 10 + y, y * 10 + x);
    }

    public int minNumber1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] < nums2[j]) {
                ans = Math.min(ans, nums1[i++] * 10 + nums2[j]);
            } else {
                ans = Math.min(ans, nums2[j++] * 10 + nums1[i]);
            }
        }
        return ans;
    }
}
