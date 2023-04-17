package com.zzh.leetcode._301_400

fun coinChange(coins: IntArray, amount: Int): Int {
    TODO()
    val dp = IntArray(amount) { -1 }
    dp[0] = 0
    for (i in 1..amount) {
        for (j in coins.indices) {
            if (coins[j] <= i) {
                dp[i] = Math.min(dp[i], dp[i - coins[j] + 1])
            }
        }
    }
}