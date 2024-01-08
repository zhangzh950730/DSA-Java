package com.zzh.leetcode.竞赛.周赛._379;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2_minMovesToCaptureTheQueen {
    public static void main(String[] args) {
        _2_minMovesToCaptureTheQueen minMovesToCaptureTheQueen = new _2_minMovesToCaptureTheQueen();
        int ans = minMovesToCaptureTheQueen.minMovesToCaptureTheQueen(1, 2, 8, 8, 2, 3);
        Assert.assertEquals(2, ans);
    }

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (c != e || ok(b, d, f)) ||
                b == f && (d != f || ok(a, c, e)) ||
                c + d == e + f && (a + b != e + f || ok(c, a, e)) ||
                c - d == e - f && (a - b != e - f || ok(c, a, e))) {
            return 1;
        }
        return 2;
    }

    private boolean ok(int l, int m, int r) {
        return m < Math.min(l, r) || m > Math.max(l, r);
    }
}
