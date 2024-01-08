package com.zzh.leetcode.竞赛.双周赛._121;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1_missingInteger {

    public static void main(String[] args) {
        _1_missingInteger missingInteger = new _1_missingInteger();
        int ans = missingInteger.missingInteger(new int[]{3, 4, 5, 1, 12, 14, 13});
        Assert.assertEquals(6, ans);
    }

    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        while (set.contains(sum)) sum++;
        return sum;
    }

}
