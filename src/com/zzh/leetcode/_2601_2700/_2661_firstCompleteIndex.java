package com.zzh.leetcode._2601_2700;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2661_firstCompleteIndex {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2};
        int[][] mat = new int[][]{{1, 4}, {2, 3}};
        _2661_firstCompleteIndex firstCompleteIndex = new _2661_firstCompleteIndex();
        int ans = firstCompleteIndex.firstCompleteIndex(arr, mat);
        Assert.assertEquals(2, ans);
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];
        for (int i = 0; i < arr.length; ++i) {
            int[] v = map.get(arr[i]);
            ++rowCnt[v[0]];
            if (rowCnt[v[0]] == m) {
                return i;
            }
            ++colCnt[v[1]];
            if (colCnt[v[1]] == n) {
                return i;
            }
        }
        return -1;
    }

}
