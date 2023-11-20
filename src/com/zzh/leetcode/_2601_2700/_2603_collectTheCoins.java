package com.zzh.leetcode._2601_2700;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2603_collectTheCoins {
    public static void main(String[] args) {
        _2603_collectTheCoins collectTheCoins = new _2603_collectTheCoins();
        int[] coins;
        int[][] edges;
        int ans;

//        coins = new int[]{1, 0, 0, 0, 0, 1};
//        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
//        ans = collectTheCoins.collectTheCoins(coins, edges);
//        Assert.assertEquals(2, ans);

        coins = new int[]{0, 0, 0, 1, 1, 0, 0, 1};
        edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {5, 6}, {5, 7}};
        ans = collectTheCoins.collectTheCoins(coins, edges);
        Assert.assertEquals(2, ans);
    }

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        var deg = new int[n];
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
            deg[x]++;
            deg[y]++; // 统计每个节点的度数（邻居个数）
        }

        int leftEdges = n - 1; // 剩余边数
        // 拓扑排序，去掉没有金币的子树
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0) { // 没有金币的叶子
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            leftEdges--; // 删除节点到其父节点的边
            for (int y : g[q.poll()]) {
                if (--deg[y] == 1 && coins[y] == 0) { // 没有金币的叶子
                    q.add(y);
                }
            }
        }

        // TODO ZhangZhiHao


        return 2;
    }

}
