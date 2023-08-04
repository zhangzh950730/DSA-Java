package com.zzh.leetcode._1401_1500;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1438_longestSubarray {

    public static void main(String[] args) {
        _1438_longestSubarray longestSubarray = new _1438_longestSubarray();
        int[] nums;
        int limit, ans;
        nums = new int[]{8, 2, 4, 7};
        limit = 4;
        ans = longestSubarray.longestSubarray(nums, limit);
        Assert.assertEquals(2, ans);

    }

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int ans = 0, left = 0, right = 0;
        while (right < nums.length) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.lastKey() - treeMap.firstKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }


}
