package com.zzh.leetcode._1201_1300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1222_queensAttacktheKing {

    public static void main(String[] args) {

    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Map<Integer, int[]> candidates = new HashMap<>();
        int kx = king[0], ky = king[1];
        for (int[] queen : queens) {
            int qx = queen[0], qy = queen[1];
            int x = qx - kx, y = qy - ky;
            if (x == 0 || y == 0 || Math.abs(x) == Math.abs(y)) {
                int dx = sgn(x), dy = sgn(y);
                int key = dx * 10 + dy;
                int distance = Math.abs(x) + Math.abs(y);
                if (!candidates.containsKey(key) || candidates.get(key)[2] > distance) {
                    candidates.put(key, new int[]{qx, qy, distance});
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : candidates.entrySet()) {
            int[] value = entry.getValue();
            List<Integer> posList = new ArrayList<>();
            ans.add(posList);
            posList.add(value[0]);
            posList.add(value[1]);
        }
        return ans;
    }

    private int sgn(int x) {
        return x > 0 ? 1 : (x == 0 ? 0 : -1);
    }

}
