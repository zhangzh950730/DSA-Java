package com.zzh.leetcode._801_900;

import org.junit.Assert;

import java.util.HashSet;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _822_flipgame {

    public static void main(String[] args) {
        _822_flipgame flipgame = new _822_flipgame();
        int[] fronts, backs;
        int ans;

        fronts = new int[]{1, 2, 4, 4, 7};
        backs = new int[]{1, 3, 4, 1, 3};
        ans = flipgame.flipgame(fronts, backs);
        Assert.assertEquals(2, ans);
    }

    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> disqualification = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) disqualification.add(fronts[i]);
        }
        int ans = Integer.MAX_VALUE;
        for (int x : fronts) {
            if (!disqualification.contains(x)) ans = Math.min(ans, x);
        }
        for (int x : backs) {
            if (!disqualification.contains(x)) ans = Math.min(ans, x);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
