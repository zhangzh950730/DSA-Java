package com.zzh.leetcode.`101-200`

fun singleNumber(nums: IntArray): Int {
    var ans = 0
    for (num in nums) {
        ans = ans xor num
    }
    return ans
}

fun main() {
    var singleNumber = singleNumber(intArrayOf(2, 2, 1))
    println("singleNumber = ${singleNumber}")
    singleNumber = singleNumber(intArrayOf(4, 1, 2, 1, 2))
    println("singleNumber = ${singleNumber}")
}