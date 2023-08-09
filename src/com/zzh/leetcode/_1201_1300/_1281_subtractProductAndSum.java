package com.zzh.leetcode._1201_1300;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1281_subtractProductAndSum {
    public static void main(String[] args) {
        _1281_subtractProductAndSum subtractProductAndSum = new _1281_subtractProductAndSum();
        int ans;

        ans = subtractProductAndSum.subtractProductAndSum(234);
        Assert.assertEquals(15, ans);

        ans = subtractProductAndSum.subtractProductAndSum(4421);
        Assert.assertEquals(21, ans);
    }

    public int subtractProductAndSum(int n) {
        int sum = 0, acc = 1;
        while (n > 0) {
            int num = n % 10;
            acc *= num;
            sum += num;
            n /= 10;
        }
        return acc - sum;
    }
}
