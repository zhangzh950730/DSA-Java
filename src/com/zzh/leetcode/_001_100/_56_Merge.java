package com.zzh.leetcode._001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _56_Merge {
    public static void main(String[] args) {
        _56_Merge merge = new _56_Merge();
        int[][] intervals;
        int[][] ans;

        intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        ans = merge.merge(intervals);
        System.out.println("ans = " + ans);

        intervals = new int[][]{{1, 4}, {4, 5}};
        ans = merge.merge(intervals);
        System.out.println("ans = " + ans);

    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{{0}};
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                int[] old = merged.get(merged.size() - 1);
                old[1] = Math.max(old[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
