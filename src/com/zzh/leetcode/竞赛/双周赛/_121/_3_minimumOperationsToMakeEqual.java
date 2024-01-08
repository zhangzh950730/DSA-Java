package com.zzh.leetcode.竞赛.双周赛._121;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _3_minimumOperationsToMakeEqual {

    public static void main(String[] args) {
        _3_minimumOperationsToMakeEqual minimumOperationsToMakeEqual = new _3_minimumOperationsToMakeEqual();
        int ans = minimumOperationsToMakeEqual.minimumOperationsToMakeEqual(26, 1);
        Assert.assertEquals(3, ans);
    }

    private final Map<Integer, Integer> memo = new HashMap<>();

    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) {
            return y - x;
        }
        if (memo.containsKey(x)) {
            return memo.get(x);
        }
        int ans = x - y;
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 11, y) + x % 11 + 1);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 11 + 1, y) + 11 - x % 11 + 1);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 5, y) + x % 5 + 1);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 5 + 1, y) + 5 - x % 5 + 1);
        memo.put(x, ans);
        return ans;
    }


}
