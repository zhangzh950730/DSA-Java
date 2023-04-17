package com.zzh.leetcode._701_800

import kotlin.test.assertEquals

fun search(nums: IntArray, target: Int): Int {
    var lo = 0
    var hi = nums.size - 1
    while (lo <= hi) {
        val mi = (hi - lo) / 2 + lo
        val candidate = nums[mi]
        if (candidate == target) {
            return mi
        } else if (candidate < target) {
            lo = mi + 1
        } else {
            hi = mi - 1
        }
    }
    return -1
}

fun main() {
    var search = search(intArrayOf(-1, 0, 3, 5, 9, 12), 9)
    assertEquals(search, 4)
    search = search(intArrayOf(-1, 0, 3, 5, 9, 12), 2)
    assertEquals(search, -1)
    search = search(intArrayOf(5), 5)
    assertEquals(search, 0)
}