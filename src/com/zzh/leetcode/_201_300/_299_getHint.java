package com.zzh.leetcode._201_300;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _299_getHint {

    public static void main(String[] args) {
        _299_getHint getHint = new _299_getHint();
        String secret, guess, ans;

//        secret = "1807";
//        guess = "7810";
//        ans = getHint.getHint(secret, guess);
//        Assert.assertEquals("1A3B", ans);

        secret = "1123";
        guess = "0111";
        ans = getHint.getHint(secret, guess);
        Assert.assertEquals("1A1B", ans);

    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++cntS[secret.charAt(i) - '0'];
                ++cntG[guess.charAt(i) - '0'];
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return bulls + "A" + cows + "B";
    }

}
