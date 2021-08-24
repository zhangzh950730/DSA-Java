package com.zzh.leetcode.竞赛.single_week.two_hundred_and_fifty_five

fun findGCD(nums: IntArray): Int {
    var min = nums[0]
    var max = nums[0]
    for (i in 1 until nums.size) {
        val num = nums[i]
        if (min > num) {
            min = num
        }
        if (max < num) {
            max = num
        }
    }
    return gcd(min, max)
}

/**
 * 欧几里得算法,计算p和q的最大公约数
 */
fun gcd(p: Int, q: Int): Int {
    return if (q == 0) p else {
        gcd(q, p % q)
    }
}

fun main() {
    var findGCD = findGCD(intArrayOf(2, 5, 6, 9, 10))
    println("findGCD = ${findGCD}")
    findGCD = findGCD(intArrayOf(7, 5, 6, 8, 3))
    println("findGCD = ${findGCD}")
    findGCD = findGCD(intArrayOf(3, 3))
    println("findGCD = ${findGCD}")
}