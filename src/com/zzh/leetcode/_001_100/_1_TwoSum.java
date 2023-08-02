package com.zzh.leetcode._001_100;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author zhangzhihao
 * @date 2020/6/1 16:42
 */
public class _1_TwoSum {
    public static void main(String[] args) {
        _1_TwoSum twoSum = new _1_TwoSum();
        int[] ans = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertArrayEquals(new int[]{0, 1}, ans);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer j = map.get(target - num);
            if (j != null) return new int[]{j, i};
            else map.put(num, i);
        }
        return null;
    }
}
