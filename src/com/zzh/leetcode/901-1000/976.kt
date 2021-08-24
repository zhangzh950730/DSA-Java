package com.zzh.leetcode.`901-1000`

/**
 * @author zhangzhihao
 * @date 2020/11/29 10:53
 */

fun largestPerimeter(A: IntArray): Int {
    A.sort()
    for (index in A.lastIndex downTo 2) {
        if (A[index] < A[index - 1] + A[index - 2]) {
            return A[index] + A[index - 1] + A[index - 2]
        }
    }
    return 0
}

fun main() {
    println(largestPerimeter(intArrayOf(3, 2, 3, 4)))
    println(largestPerimeter(intArrayOf(3, 6, 2, 3)))
    println(largestPerimeter(intArrayOf(1, 2, 1)))
}