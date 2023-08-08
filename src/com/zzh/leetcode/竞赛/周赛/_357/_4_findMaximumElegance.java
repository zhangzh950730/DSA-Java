package com.zzh.leetcode.竞赛.周赛._357;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _4_findMaximumElegance {
    public static void main(String[] args) {
        _4_findMaximumElegance findMaximumElegance = new _4_findMaximumElegance();

        int[][] items;
        int k;
        long ans;

        items = new int[][]{{3, 1}, {3, 1}, {2, 2}, {5, 3}};
        k = 3;
        ans = findMaximumElegance.findMaximumElegance(items, k);
        Assert.assertEquals(19, ans);
    }

    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (o1, o2) -> o2[0] - o1[0]);
        long ans = 0, totalProfit = 0;
        HashSet<Integer> vis = new HashSet<>();
        ArrayDeque<Integer> duplicate = new ArrayDeque<>();
        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            if (i < k) {
                totalProfit += profit;
                if (!vis.add(category)) duplicate.push(profit);
            } else if (!duplicate.isEmpty() && vis.add(category)) {
                totalProfit += profit - duplicate.poll();
            }
            ans = Math.max(ans, totalProfit + (long) vis.size() * vis.size());
        }
        return ans;
    }
}
