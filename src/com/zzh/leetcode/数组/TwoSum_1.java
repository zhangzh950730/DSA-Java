package com.zzh.leetcode.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * @author zhangzhihao
 * @date 2020/6/1 16:42
 */
public class TwoSum_1 {
    /**
     *  一遍哈希表
     */
    static class Solution {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.containsKey(target - num)) {
                    return new int[]{map.get(target - num), i};
                }
                map.put(num, i);
            }
            return new int[]{-1, -1};
        }

        public static void main(String[] args) {
            int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
            System.out.println(ints[0] + " , " + ints[1]);
        }
    }
}
