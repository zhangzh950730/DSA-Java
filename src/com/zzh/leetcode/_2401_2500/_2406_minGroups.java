package com.zzh.leetcode._2401_2500;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2406_minGroups {
    public static void main(String[] args) {
        _2406_minGroups minGroups = new _2406_minGroups();
        int[][] intervals = new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        int ans = minGroups.minGroups(intervals);
        Assert.assertEquals(3, ans);
    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            pq.offer(interval[1]);
        }
        return pq.size();
    }

}
