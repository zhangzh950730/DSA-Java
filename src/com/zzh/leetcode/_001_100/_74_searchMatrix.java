package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _74_searchMatrix {
    public static void main(String[] args) {
        _74_searchMatrix searchMatrix = new _74_searchMatrix();
        int[][] matrix;
        int target;
        boolean ans;

//        matrix = new int[][]{{1, 3, 5, 6}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        target = 3;
//        ans = searchMatrix.searchMatrix(matrix, target);
//        Assert.assertTrue(ans);


        matrix = new int[][]{{1, 3}};
        target = 3;
        ans = searchMatrix.searchMatrix(matrix, target);
        Assert.assertTrue(ans);

    }

    public boolean searchMatrix(int[][] mat, int t) {
        int m = mat.length, n = mat[0].length;
        int left = 0, right = m * n - 1, mid;
        while (left < right) {
            mid = left + right + 1 >> 1;
            if (mat[mid / n][mid % n] <= t) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return mat[right / n][right % n] == t;
    }

}
