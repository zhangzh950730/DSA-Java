package com.zzh.leetcode._2801_2900;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2848_numberOfPoints {
    public static void main(String[] args) {
        _2848_numberOfPoints numberOfPoints = new _2848_numberOfPoints();
        List<List<Integer>> nums;
        int ans;

        nums = new ArrayList<>();
        nums.add(Arrays.asList(3, 6));
        nums.add(Arrays.asList(1, 5));
        nums.add(Arrays.asList(4, 7));
        ans = numberOfPoints.numberOfPoints(nums);
        Assert.assertEquals(7, ans);

    }

    public int numberOfPoints(List<List<Integer>> nums) {
        var diff = new int[102];
        for (var p : nums) {
            diff[p.get(0)]++;
            diff[p.get(1) + 1]--;
        }
        int ans = 0, s = 0;
        for (int d : diff) {
            s += d;
            if (s > 0) {
                ans++;
            }
        }
        return ans;
    }

}
