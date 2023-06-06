package com.zzh.leetcode._2301_2400;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2352_Equalpairs {

    public static void main(String[] args) {
        _2352_Equalpairs equalpairs = new _2352_Equalpairs();
        int[][] grid;
        int ans;

        grid = new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        ans = equalpairs.equalPairs(grid);
        Assert.assertEquals(ans, 1);

        grid = new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        ans = equalpairs.equalPairs(grid);
        Assert.assertEquals(ans, 3);
    }

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> map = new HashMap<>(n);
        for (int[] row : grid) {
            List<Integer> keyList = new ArrayList<>(n);
            for (int num : row) keyList.add(num);
            map.put(keyList, map.getOrDefault(keyList, 0) + 1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> keyList = new ArrayList<>(n);
            for (int[] row : grid) {
                keyList.add(row[i]);
            }
            ans += map.getOrDefault(keyList, 0);
        }
        return ans;
    }

}
