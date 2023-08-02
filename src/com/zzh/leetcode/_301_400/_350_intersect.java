package com.zzh.leetcode._301_400;

import com.google.common.primitives.Ints;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _350_intersect {
    public static void main(String[] args) {
        _350_intersect intersect = new _350_intersect();
        int[] nums1, nums2, ans;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};
        ans = intersect.intersect(nums1, nums2);
        Assert.assertArrayEquals(new int[]{2, 2}, ans);

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        ans = intersect.intersect(nums1, nums2);
        Assert.assertArrayEquals(new int[]{9, 4}, ans);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.merge(num, 1, Integer::sum);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                map.merge(num, -1, Integer::sum);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

}
