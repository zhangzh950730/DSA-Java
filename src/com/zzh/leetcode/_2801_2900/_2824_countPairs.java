package com.zzh.leetcode._2801_2900;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2824_countPairs {
    public static void main(String[] args) {
        _2824_countPairs countPairs = new _2824_countPairs();
        int ans = countPairs.countPairs(Arrays.asList(-5, -4, -10, 7), 14);
        Assert.assertEquals(6, ans);
    }

    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans = 0, left = 0, right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                ans += right - left;
                left++;
            } else right--;
        }
        return ans;
    }

}
