package com.zzh.leetcode._1501_1600;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1527_diagonalSum {
    public static void main(String[] args) {
        _1527_diagonalSum diagonalSum = new _1527_diagonalSum();
        int[][] mat;
        int ans;

        mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ans = diagonalSum.diagonalSum(mat);
        Assert.assertEquals(25, ans);
    }

    public int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0, mid = n / 2;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i] + mat[i][n - i - 1];
        }
        return sum - mat[mid][mid] * (n & 1);
    }

    public int diagonalSum1(int[][] mat) {
        int n = mat.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int[] nums = mat[i];
            for (int j = 0; j < nums.length; j++) {
                int x = nums[j];
                if (i == j || i + j == n - 1) {
                    ans += x;
                }
            }
        }
        return ans;
    }
}
