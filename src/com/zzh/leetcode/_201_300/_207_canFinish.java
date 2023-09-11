package com.zzh.leetcode._201_300;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _207_canFinish {
    public static void main(String[] args) {
        _207_canFinish canFinish = new _207_canFinish();
        int numCourses;
        int[][] prerequisites;
        boolean ans;

        numCourses = 2;
        prerequisites = new int[][]{{1, 0}};
        ans = canFinish.canFinish(numCourses, prerequisites);
        Assert.assertTrue(ans);


    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // TODO ZhangZhiHao
        return false;
    }

}
