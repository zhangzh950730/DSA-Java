package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _88_merge {

    public static void main(String[] args) {
        _88_merge merge = new _88_merge();
        int[] nums1, nums2;
        int m, n;

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        m = 3;
        n = 3;
        merge.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[]{1};
        nums2 = new int[]{};
        m = 1;
        n = 0;
        merge.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[]{0};
        nums2 = new int[]{1};
        m = 0;
        n = 1;
        merge.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[]{4, 0, 0, 0, 0, 0};
        nums2 = new int[]{1, 2, 3, 5, 6};
        m = 1;
        n = 5;
        merge.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m > 0) System.arraycopy(nums1, 0, nums1, n, m);

        int i = n, j = 0, k = 0;
        while (j < n) {
            if (i < nums1.length && nums1[i] <= nums2[j]) {
                nums1[k++] = nums1[i++];
            } else if (i == nums1.length || nums1[i] > nums2[j]) {
                nums1[k++] = nums2[j++];
            }
        }
    }


}
