package com.zzh.leetcode._101_200

import kotlin.test.assertEquals

/**
 * 动态规划 空间优化
 * 时间复杂度: O(n^2),n是三角形的行数
 * 空间复杂度: O(n)
 */
fun minimumTotal(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val f = IntArray(n)
    f[0] = triangle[0][0]
    for (i in 1 until n) {
        f[i] = f[i - 1] + triangle[i][i]
        for (j in i - 1 downTo 1) {
            f[j] = Math.min(f[j - 1], f[j]) + triangle[i][j]
        }
        f[0] += triangle[i][0]
    }
    var minTotal = f[0]
    for (i in 1 until n) {
        minTotal = Math.min(minTotal, f[i])
    }
    return minTotal
}

/**
 * 动态规划
 * 时间复杂度: O(n^2),n是三角形的行数
 * 空间复杂度: O(n^2),需要n*n的二维数组存放所有的状态
 */
fun minimumTotal1(triangle: List<List<Int>>): Int {
    val n = triangle.size
    val f = Array(n) { IntArray(n) }
    f[0][0] = triangle[0][0]
    for (i in 1 until n) {
        f[i][0] = f[i - 1][0] + triangle[i][0]
        for (j in 1 until i) {
            f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j]
        }
        f[i][i] = f[i - 1][i - 1] + triangle[i][i]
    }
    var minTotal = f[n - 1][0]
    for (i in 1 until n) {
        minTotal = Math.min(minTotal, f[n - 1][i])
    }
    return minTotal
}

fun main() {
    var minimumTotal = minimumTotal(listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3)))
    assertEquals(minimumTotal, 11)
    minimumTotal = minimumTotal(listOf(listOf(-10)))
    assertEquals(minimumTotal, -10)
}