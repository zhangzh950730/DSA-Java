package com.zzh.leetcode._2501_2600;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2511_captureForts {
    public static void main(String[] args) {
        _2511_captureForts captureForts = new _2511_captureForts();
        int[] forts = new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1};

        int ans = captureForts.captureForts(forts);
        Assert.assertEquals(4, ans);

    }

    public int captureForts(int[] forts) {
        int pre = -1, ans = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }
}
