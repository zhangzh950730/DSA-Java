package com.zzh.leetcode._2701_2800;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2798_numberOfEmployeesWhoMetTarget {

    public static void main(String[] args) {
        _2798_numberOfEmployeesWhoMetTarget numberOfEmployeesWhoMetTarget = new _2798_numberOfEmployeesWhoMetTarget();
        int[] hours;
        int target;
        int ans;

        hours = new int[]{0, 1, 2, 3, 4};
        target = 2;
        ans = numberOfEmployeesWhoMetTarget.numberOfEmployeesWhoMetTarget(hours, target);
        Assert.assertEquals(3, ans);

        hours = new int[]{5, 1, 4, 2, 2};
        target = 6;
        ans = numberOfEmployeesWhoMetTarget.numberOfEmployeesWhoMetTarget(hours, target);
        Assert.assertEquals(0, ans);
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour >= target) ans++;
        }
        return ans;
    }

}
