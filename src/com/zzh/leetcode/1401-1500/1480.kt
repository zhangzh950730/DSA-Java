package com.zzh.leetcode.`1401-1500`

fun runningSum(nums: IntArray): IntArray {
    for (i in 1 until nums.size) {
        nums[i] += nums[i - 1]
    }
    return nums
}

fun main() {
    var runningSum = runningSum(intArrayOf(1, 2, 3, 4))
    println("runningSum = ${runningSum}")
    runningSum = runningSum(intArrayOf(1, 1, 1, 1, 1))
    println("runningSum = ${runningSum}")
    runningSum = runningSum(intArrayOf(3, 1, 2, 10, 1))
    println("runningSum = ${runningSum}")
}