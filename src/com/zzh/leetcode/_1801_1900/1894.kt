package com.zzh.leetcode._1801_1900

import org.junit.Assert.assertEquals

fun chalkReplacer(chalk: IntArray, k: Int): Int {
    var sum = 0L
    for (cha in chalk) {
        sum += cha
    }
    var mod = k % sum
    for (i in chalk.indices) {
        mod -= chalk[i]
        if (mod < 0) return i
    }
    return -1
}

fun main() {
    val chalkReplacer = chalkReplacer(intArrayOf(5, 1, 5), 22)
    assertEquals(chalkReplacer, 0)
}