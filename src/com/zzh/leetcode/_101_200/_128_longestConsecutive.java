package com.zzh.leetcode._101_200;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _128_longestConsecutive {

    public static void main(String[] args) {
        _128_longestConsecutive longestConsecutive = new _128_longestConsecutive();
        int[] nums;
        int ans;

        nums = new int[]{100, 4, 200, 1, 3, 2};
        ans = longestConsecutive.longestConsecutive(nums);
        Assert.assertEquals(4, ans);

        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        ans = longestConsecutive.longestConsecutive(nums);
        Assert.assertEquals(9, ans);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int ans = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentAns = 1;
                int currentNum = num;
                while (set.contains(++currentNum)) currentAns++;
                ans = Math.max(ans, currentAns);
            }
        }
        return ans;
    }
}
