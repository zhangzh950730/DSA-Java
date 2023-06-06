package com.zzh.leetcode._2401_2500;

import org.junit.Assert;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2465_DistinctAverages {

    public static void main(String[] args) {
        int[] nums;
        int ans;
        _2465_DistinctAverages distinctAverages = new _2465_DistinctAverages();

        nums = new int[]{4, 1, 4, 0, 3, 5};
        ans = distinctAverages.distinctAverages(nums);
        Assert.assertEquals(ans, 2);

        nums = new int[]{1, 100};
        ans = distinctAverages.distinctAverages(nums);
        Assert.assertEquals(ans, 1);

        nums = new int[]{10, 2, 2, 0, 4, 0};
        ans = distinctAverages.distinctAverages(nums);
        Assert.assertEquals(ans, 2);

        nums = new int[]{9, 5, 7, 8, 7, 9, 8, 2, 0, 7};
        ans = distinctAverages.distinctAverages(nums);
        Assert.assertEquals(ans, 5);

    }

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            set.add(nums[i] + nums[j]);
        }
        return set.size();
    }
}
