package com.zzh.leetcode._301_400;

import org.junit.Assert;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _378_kthSmallest {
    public static void main(String[] args) {
        _378_kthSmallest kthSmallest = new _378_kthSmallest();
        int[][] matrix;
        int k, ans;

        matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        k = 8;
        ans = kthSmallest.kthSmallest(matrix, k);
        Assert.assertEquals(13, ans);


    }

    public int kthSmallest(int[][] matrix, int k) {
        // 最小元素, 大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i = 0;
        for (int[] nums : matrix) {
            for (int num : nums) {
                if (i++ < k) pq.offer(num);
                else if (pq.comparator().compare(num, pq.peek()) > 0) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }
        return pq.peek();
    }
}
