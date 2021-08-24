package com.zzh.leetcode.`801-900`

import kotlin.UnsupportedOperationException
import kotlin.math.max
import kotlin.math.pow

/**
 * @author zhangzhihao
 * @date 2020/12/7 8:35
 */

fun matrixScore(A: Array<IntArray>): Int {
    val m = A.size
    val n = A[0].size
    var result = m * (1.shl(n - 1))
    for (j in 1 until n) {
        var nOnes = 0
        for (i in 0 until m) {
            nOnes += if (A[i][0] == 1) {
                A[i][j]
            } else {
                (1 - A[i][j])
            }
        }
        val k = Math.max(nOnes, m - nOnes)
        result += k * (1.shl(n - j - 1))
    }
    return result
}

fun main() {
    var array = arrayOf(intArrayOf(0, 0, 1, 1), intArrayOf(1, 0, 1, 0), intArrayOf(1, 1, 0, 0))
    var matrixScore = matrixScore(array)
    println("matrixScore = ${matrixScore}")
    array = arrayOf(intArrayOf(0), intArrayOf(1))
    matrixScore = matrixScore(array)
    println("matrixScore = ${matrixScore}")
    array = arrayOf(intArrayOf(0, 1), intArrayOf(0, 1), intArrayOf(0, 1), intArrayOf(0, 0))
    matrixScore = matrixScore(array)
    println("matrixScore = ${matrixScore}")
}