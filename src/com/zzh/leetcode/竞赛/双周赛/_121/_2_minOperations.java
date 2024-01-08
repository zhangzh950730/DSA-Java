package com.zzh.leetcode.竞赛.双周赛._121;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2_minOperations {

    public static void main(String[] args) {
        _2_minOperations minOperations = new _2_minOperations();
        int ans = minOperations.minOperations(new int[]{2, 1, 3, 4}, 1);
        Assert.assertEquals(2, ans);
    }

    public int minOperations(int[] nums, int k) {
        for (int x : nums) {
            k ^= x;
        }
        return Integer.bitCount(k);
    }

}
