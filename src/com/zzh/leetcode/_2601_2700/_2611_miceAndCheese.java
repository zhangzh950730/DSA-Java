package com.zzh.leetcode._2601_2700;

import org.junit.Assert;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2611_miceAndCheese {

    public static void main(String[] args) {
        _2611_miceAndCheese miceAndCheese = new _2611_miceAndCheese();
        int[] reward1, reward2;
        int k, ans;

        reward1 = new int[]{1, 1, 3, 4};
        reward2 = new int[]{4, 4, 1, 1};
        k = 2;
        ans = miceAndCheese.miceAndCheese(reward1, reward2, k);
        Assert.assertEquals(ans, 15);

        reward1 = new int[]{1, 1};
        reward2 = new int[]{1, 1};
        k = 2;
        ans = miceAndCheese.miceAndCheese(reward1, reward2, k);
        Assert.assertEquals(ans, 2);
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0, n = reward1.length;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            heap.offer(reward1[i] - reward2[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        while (!heap.isEmpty()) {
            ans += heap.poll();
        }
        return ans;
    }

    public int miceAndCheese1(int[] reward1, int[] reward2, int k) {
        int ans = 0, n = reward1.length;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            diffs[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diffs);
        for (int i = 1; i <= k; i++) {
            ans += diffs[n - i];
        }
        return ans;
    }
}
