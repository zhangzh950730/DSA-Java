package com.zzh.leetcode.竞赛.双周赛._110;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1_accountBalanceAfterPurchase {

    public static void main(String[] args) {
        _1_accountBalanceAfterPurchase accountBalanceAfterPurchase = new _1_accountBalanceAfterPurchase();
        int purchaseAmount, ans;

        purchaseAmount = 9;
        ans = accountBalanceAfterPurchase.accountBalanceAfterPurchase(purchaseAmount);
        Assert.assertEquals(90, ans);

        purchaseAmount = 15;
        ans = accountBalanceAfterPurchase.accountBalanceAfterPurchase(purchaseAmount);
        Assert.assertEquals(80, ans);
    }

    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount + 5) / 10 * 10;
    }
}
