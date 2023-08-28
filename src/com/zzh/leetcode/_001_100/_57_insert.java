package com.zzh.leetcode._001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _57_insert {
    public static void main(String[] args) {
        _57_insert insert = new _57_insert();
        int[][] intervals;
        int[] newInterval;
        int[][] ans;

        intervals = new int[][]{{1, 3}, {6, 9}};
        newInterval = new int[]{2, 5};
        ans = insert.insert(intervals, newInterval);
        System.out.println("ans = " + ans);

        intervals = new int[][]{};
        newInterval = new int[]{5, 7};
        ans = insert.insert(intervals, newInterval);
        System.out.println("ans = " + ans);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = Arrays.copyOf(intervals, intervals.length + 1);
        intervals[intervals.length - 1] = newInterval;
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
