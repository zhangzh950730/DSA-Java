package com.zzh.geektime.数据结构与算法之美

fun minDistDP(matrix: Array<IntArray>, n: Int): Int {
    val states = Array(n) { IntArray(n) }
    var sum = 0

    // 初始化第一行
    for (j in 0 until n) {
        sum += matrix[0][j]
        states[0][j] = sum
    }

    sum = 0
    // 初始化第一列
    for (i in 0 until n) {
        sum += matrix[i][0]
        states[i][0] = sum
    }

    for (i in 1 until n) {
        for (j in 1 until n) {
            states[i][j] = Math.min(states[i][j - 1], states[i - 1][j]) + matrix[i][j]
        }
    }

    return states[n - 1][n - 1]
}

/**
 * 价值版本
 * @param weight 物品重量
 * @param value 物品价值
 * @param n 物品个数
 * @param w 背包可承载重量
 */
fun knapsack(weight: IntArray, value: IntArray, n: Int, w: Int): Int {
    val states = Array(n) { IntArray(w + 1) { -1 } }
    states[0][0] = 0
    if (weight[0] <= w) {
        states[0][weight[0]] = value[0]
    }
    for (i in 1 until n) { //动态规划,状态转移
        for (j in 0..w) { // 不选择第i个物品
            if (states[i - 1][j] >= 0) {
                states[i][j] = states[i - 1][j]
            }
        }
        for (j in 0..w - weight[i]) { //选择第个物品
            if (states[i - 1][j] >= 0) {
                val v = states[i - 1][j] + value[i]
                if (v > states[i][j + weight[i]]) {
                    states[i][j + weight[i]] = v
                }
            }
        }
    }

    var maxValue = -1
    for (j in 0..w) {
        if (states[n - 1][j] > maxValue) {
            maxValue = states[n - 1][j]
        }
    }
    return maxValue
}

/**
 * 一维数组版本
 * @param weight 物品重量
 * @param n 物品个数
 * @param w 背包可承载重量
 */
fun knapsack2(weight: IntArray, n: Int, w: Int): Int {
    val states = BooleanArray(w + 1)
    states[0] = true
    if (weight[0] <= w) {
        states[weight[0]] = true
    }
    for (i in 1 until n) {
        for (j in w - weight[i] downTo 0) {
            if (states[j]) {
                states[j + weight[i]] = true
            }
        }
    }
    for (i in w downTo 0) {
        if (states[i]) {
            return i
        }
    }
    return 0
}

/**
 * 二维数组版本
 * @param weight 物品重量
 * @param n 物品个数
 * @param w 背包可承载重量
 */
fun knapsack1(weight: IntArray, n: Int, w: Int): Int {
    val states = Array(n) { BooleanArray(w + 1) }
    states[0][0] = true
    if (weight[0] <= w) { //处理第一行数据
        states[0][weight[0]] = true
    }
    for (i in 1 until n) {
        // 不把第i个物品放入背包
        for (j in 0..w) {
            if (states[i - 1][j]) {
                states[i][j] = states[i - 1][j]
            }
        }
        // 把第i个物品放入背包
        for (j in 0..(w - weight[i])) {
            if (states[i - 1][j]) {
                states[i][j + weight[i]] = true
            }
        }
    }
    for (i in w downTo 0) {
        if (states[n - 1][i]) {
            return i
        }
    }
    return 0
}

fun main() {
    val knapsack = knapsack(
        intArrayOf(2, 2, 4, 6, 3), intArrayOf(3, 4, 8, 9, 6), 5, 9
    )
    println("knapsack = ${knapsack}")

    val minDistDP = minDistDP(
        arrayOf(intArrayOf(1, 3, 5, 9), intArrayOf(2, 1, 3, 4), intArrayOf(5, 2, 6, 7), intArrayOf(6, 8, 4, 3)),
        n = 4
    )
    println("minDistDP = ${minDistDP}")
}