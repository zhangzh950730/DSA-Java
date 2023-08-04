package com.zzh.leetcode._201_300;

import org.junit.Assert;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _264_nthUglyNumber {

    public static void main(String[] args) {
        _264_nthUglyNumber nthUglyNumber = new _264_nthUglyNumber();
        int n, ans;

        n = 10;
        ans = nthUglyNumber.nthUglyNumber(n);
        Assert.assertEquals(12, ans);

        n = 1;
        ans = nthUglyNumber.nthUglyNumber(n);
        Assert.assertEquals(1, ans);

        n = 1407;
        ans = nthUglyNumber.nthUglyNumber(n);
        Assert.assertEquals(536870912, ans);
    }

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.offer(1L);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long x = pq.poll();
            ans = (int) x;
            for (int factor : factors) {
                long next = factor * x;
                if (set.add(next)) {
                    pq.offer(next);
                }
            }
        }
        return ans;
    }

}
