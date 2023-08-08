package com.zzh.leetcode.竞赛.周赛._357;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _3_maximumSafenessFactor {

    public static void main(String[] args) {
        _3_maximumSafenessFactor maximumSafenessFactor = new _3_maximumSafenessFactor();
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(1, 0, 0));
        grid.add(Arrays.asList(0, 0, 0));
        grid.add(Arrays.asList(0, 0, 1));
        int ans = maximumSafenessFactor.maximumSafenessFactor(grid);
        Assert.assertEquals(0, ans);
    }

    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        var q = new ArrayList<int[]>(); // 存储小偷的索引
        var dis = new int[n][n]; // 存储曼哈顿距离
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) > 0) {
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        var groups = new ArrayList<List<int[]>>();
        groups.add(q);
        while (!q.isEmpty()) { // 多源 BFS
            var tmp = q;
            q = new ArrayList<>();
            for (var p : tmp) {
                for (var d : DIRS) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < n && 0 <= y && y < n && dis[x][y] < 0) {
                        q.add(new int[]{x, y});
                        dis[x][y] = groups.size();
                    }
                }
            }
            groups.add(q); // 相同 dis 分组记录
        }

        // 并查集
        fa = new int[n * n];
        for (int i = 0; i < n * n; i++)
            fa[i] = i;

        for (int ans = groups.size() - 2; ans > 0; ans--) {
            var g = groups.get(ans);
            for (var p : groups.get(ans)) {
                int i = p[0], j = p[1];
                for (var d : DIRS) {
                    int x = i + d[0], y = j + d[1];
                    if (0 <= x && x < n && 0 <= y && y < n && dis[x][y] >= dis[i][j])
                        fa[find(x * n + y)] = find(i * n + j);
                }
            }
            if (find(0) == find(n * n - 1)) // 写这里判断更快些
                return ans;
        }
        return 0;
    }

    // 并查集模板
    private int[] fa;

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }

}
