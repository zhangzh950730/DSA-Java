package com.zzh.leetcode.`001-100`

fun maxSubArray(nums: IntArray): Int {
    var pre = 0
    var maxAns = nums[0]
    for (num in nums) {
        pre = Math.max(pre + num, num)
        maxAns = Math.max(maxAns, pre)
    }
    return maxAns
}

fun main() {
    val maxSubArray = maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    println("maxSubArray = ${maxSubArray}")
}