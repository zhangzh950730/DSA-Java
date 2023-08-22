package com.zzh.leetcode._801_900;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _849_maxDistToClosest {
    public static void main(String[] args) {
        _849_maxDistToClosest maxDistToClosest = new _849_maxDistToClosest();
        int[] seats;
        int ans;

        seats = new int[]{1, 0, 0, 0, 1, 0, 1};
        ans = maxDistToClosest.maxDistToClosest(seats);
        Assert.assertEquals(2, ans);
    }

    public int maxDistToClosest(int[] seats) {
        int ans, left = 0, right, n = seats.length;
        while (left < n && seats[left] == 0) left++;
        ans = left;
        while (left < seats.length) {
            right = left + 1;
            while (right < n && seats[right] == 0) right++;
            if (right == n) { // 最后一个座位为空, 只需计算到左边的距离
                ans = Math.max(ans, right - left - 1);
            } else { //中间位置为空, 计算到两边的最大距离
                ans = Math.max(ans, (right - left) / 2);
            }
            left = right;
        }
        return ans;
    }
}
