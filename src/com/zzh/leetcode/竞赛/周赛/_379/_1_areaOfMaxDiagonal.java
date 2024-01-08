package com.zzh.leetcode.竞赛.周赛._379;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1_areaOfMaxDiagonal {

    public static void main(String[] args) {
        _1_areaOfMaxDiagonal areaOfMaxDiagonal = new _1_areaOfMaxDiagonal();
        int ans = areaOfMaxDiagonal.areaOfMaxDiagonal(new int[][]{{1, 10}, {3, 10}});
        Assert.assertEquals(30, ans);
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxL = 0, ans = 0;
        for (int[] dimension : dimensions) {
            int x = dimension[0], y = dimension[1];
            int l = x * x + y * y;
            if (l > maxL || l == maxL && x * y > ans) {
                maxL = l;
                ans = x * y;
            }
        }
        return ans;
    }
}
