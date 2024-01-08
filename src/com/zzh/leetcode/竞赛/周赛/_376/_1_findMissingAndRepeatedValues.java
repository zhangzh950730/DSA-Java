package com.zzh.leetcode.竞赛.周赛._376;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1_findMissingAndRepeatedValues {
    public static void main(String[] args) {

    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n * n + 1];
        for (int[] ints : grid) {
            for (int anInt : ints) {
                arr[anInt]++;
            }
        }

        int[] ans = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (arr[i] > 1) ans[0] = i;
            else if (arr[i] == 0) ans[1] = i;
        }
        return ans;
    }
}
