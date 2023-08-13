package com.zzh.leetcode.竞赛.周赛._358;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _3_minAbsoluteDifference {
    public static void main(String[] args) {
        _3_minAbsoluteDifference minAbsoluteDifference = new _3_minAbsoluteDifference();
        List<Integer> nums;
        int x, ans;

        nums = new ArrayList<>();
        nums.add(4);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        x = 2;
        ans = minAbsoluteDifference.minAbsoluteDifference(nums, x);
        Assert.assertEquals(0, ans);
    }

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int ans = Integer.MAX_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(Integer.MAX_VALUE);
        set.add(Integer.MIN_VALUE / 2);
        for (int i = x; i < nums.size(); i++) {
            set.add(nums.get(i - x));
            Integer num = nums.get(i);
            ans = Math.min(ans, Math.min(set.ceiling(num) - num, num - set.floor(num)));
        }
        return ans;
    }

}
