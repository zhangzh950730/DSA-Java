package com.zzh.leetcode._2201_2300;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2216_minDeletion {
    public static void main(String[] args) {
        _2216_minDeletion minDeletion = new _2216_minDeletion();
        int ans = minDeletion.minDeletion(new int[]{7, 4});
        Assert.assertEquals(0, ans);
    }

    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        boolean check = true;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] == nums[i + 1] && check) {
                ans++;
            } else {
                check = !check;
            }
        }
        if ((n - ans) % 2 != 0) ans++;
        return ans;
    }
}
