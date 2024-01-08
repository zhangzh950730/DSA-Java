package com.zzh.leetcode._1101_1200;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1109_corpFlightBookings {
    public static void main(String[] args) {
        _1109_corpFlightBookings corpFlightBookings = new _1109_corpFlightBookings();
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ans = corpFlightBookings.corpFlightBookings(bookings, 5);
        Assert.assertArrayEquals(new int[]{10, 55, 45, 25, 25}, ans);
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int first = booking[0], last = booking[1], seats = booking[2];
            ans[first - 1] += seats;
            if (last < n) {
                ans[last] -= seats;
            }
        }

        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }

}
