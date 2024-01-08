package com.zzh.leetcode._1401_1500;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1423_maxScore {
    public static void main(String[] args) {
        _1423_maxScore maxScore = new _1423_maxScore();
        int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        int ans = maxScore.maxScore(cardPoints, 3);
        Assert.assertEquals(12, ans);
    }

    public int maxScore(int[] cardPoints, int k) {
        int s = 0;
        for (int i = 0; i < k; i++) {
            s += cardPoints[i];
        }
        int ans = s;
        for (int i = 1; i <= k; i++) {
            s += cardPoints[cardPoints.length - i] - cardPoints[k - i];
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
