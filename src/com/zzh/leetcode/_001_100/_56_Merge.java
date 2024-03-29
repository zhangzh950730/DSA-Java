package com.zzh.leetcode._001_100;

import java.util.*;

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
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(new int[]{left, right});
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], right);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
