package com.zzh.leetcode._901_1000;

import org.apache.commons.text.diff.KeepCommand;
import org.junit.Assert;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _973_kClosest {

    public static void main(String[] args) {
        _973_kClosest kClosest = new _973_kClosest();
        int[][] points, ans;
        int k;

        points = new int[][]{{1, 3}, {-2, 2}};
        k = 1;
        ans = kClosest.kClosest(points, k);
        Assert.assertArrayEquals(new int[][]{{-2, 2}}, ans);

        points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        k = 2;
        ans = kClosest.kClosest(points, k);
        Assert.assertArrayEquals(new int[][]{{-2, 4}, {3, 3}}, ans);

        points = new int[][]{{0, 1}, {1, 0}};
        k = 2;
        ans = kClosest.kClosest(points, k);
        Assert.assertArrayEquals(new int[][]{{0, 1}, {1, 0}}, ans);
    }

    public int[][] kClosest(int[][] points, int k) {
        // pq默认为小顶堆, 此处需要大顶堆,所以重写比较器
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] * o2[0] + o2[1] * o2[1] - o1[0] * o1[0] - o1[1] * o1[1]);
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (i < k) {
                pq.offer(point);
            } else if (pq.comparator().compare(point, pq.peek()) > 0) { // 当前point比堆顶值小时,将point入堆
                pq.poll();
                pq.offer(point);
            }
        }
        int[][] ans = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
