package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _4_findMedianSortedArrays {

    public static void main(String[] args) {
        _4_findMedianSortedArrays findMedianSortedArrays = new _4_findMedianSortedArrays();
        int[] nums1, nums2;
        double ans;

        nums1 = new int[]{1, 3};
        nums2 = new int[]{2};
        ans = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(ans, 2, 0);

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        ans = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(ans, 2.5, 0);

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1 + l2];
        for (int i = 0, j = 0, k = 0; i < l1 || j < l2; k++) {
            if (i < l1 && (j == l2 || nums1[i] < nums2[j])) {
                nums[k] = nums1[i++];
            } else if (i == l1 || nums2[j] <= nums1[i]) {
                nums[k] = nums2[j++];
            }
        }

        int n = nums.length;
        if (n % 2 == 0) {
            int r = n / 2;
            return (nums[r - 1] + nums[r]) / 2.0;
        } else {
            return nums[n / 2];
        }
    }

}
