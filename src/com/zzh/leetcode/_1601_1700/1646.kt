package com.zzh.leetcode._1601_1700

fun getMaximumGenerated(n: Int): Int {
    if (n == 0) {
        return 0
    }
    val nums = IntArray(n + 1)
    nums[1] = 1

    for (i in 2..n) {
        nums[i] = nums[i / 2] + i % 2 * nums[i / 2 + 1]
    }

    var max = nums[0]
    for (i in 1 until nums.size) {
        if (nums[i] > max) {
            max = nums[i]
        }
    }
    return max
}

fun main() {
    var maximumGenerated = getMaximumGenerated(7)
    println("maximumGenerated = ${maximumGenerated}")

    maximumGenerated = getMaximumGenerated(2)
    println("maximumGenerated = ${maximumGenerated}")

    maximumGenerated = getMaximumGenerated(3)
    println("maximumGenerated = ${maximumGenerated}")
}
