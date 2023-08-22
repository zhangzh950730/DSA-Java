package com.zzh.leetcode._2601_2700;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2682_circularGameLosers {
    public static void main(String[] args) {
        _2682_circularGameLosers circularGameLosers = new _2682_circularGameLosers();
        int n, k;
        int[] ans;

        n = 5;
        k = 2;
        ans = circularGameLosers.circularGameLosers(n, k);
        System.out.println("ans = " + ans);
    }

    public int[] circularGameLosers(int n, int k) {
        int[] counter = new int[n];
        int ansN = n;
        for (int i = 0, j = 0; ; i++) {
            j = (j + k * i) % n;
            if (counter[j] == 1) {
                break;
            } else {
                ansN--;
                counter[j] = 1;
            }
        }
        int[] ans = new int[ansN];
        for (int i = 0, j = 0; i < counter.length; i++) {
            if (counter[i] == 0) ans[j++] = i + 1;
        }
        return ans;
    }
}
