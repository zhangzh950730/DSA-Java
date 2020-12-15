package com.zzh.leetcode

/**
 * @author zhangzhihao
 * @date 2020/12/14 10:54
 */

fun containsDuplicate(nums: IntArray): Boolean {
    nums.sort()
    for (index in 0 until nums.size - 1) {
        if (nums[index] == nums[index + 1]) {
            return true
        }
    }
    return false
}

fun main() {
    var result = containsDuplicate(intArrayOf(1, 2, 3, 1))
    println("result = ${result}")
    result = containsDuplicate(intArrayOf(1, 2, 3, 4))
    println("result = ${result}")
    result = containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2))
    println("result = ${result}")
    result = containsDuplicate(intArrayOf(3, 3))
    println("result = ${result}")
    result = containsDuplicate(intArrayOf(1, 5, -2, -4, 0))
    println("result = ${result}")
}