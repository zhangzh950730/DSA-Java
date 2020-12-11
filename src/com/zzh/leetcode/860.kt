package com.zzh.leetcode

/**
 * @author zhangzhihao
 * @date 2020/12/10 8:57
 */
fun lemonadeChange(bills: IntArray): Boolean {
    var five = 0
    var ten = 0
    for (bill in bills) {
        if (bill == 5) five++
        else if (bill == 10) {
            five--
            ten++
        } else if (ten > 0) {
            ten--
            five--
        } else five -= 3
        if (five < 0) {
            return false
        }
    }
    return true
}

fun main() {
    var result = lemonadeChange(intArrayOf(5, 5, 5, 10, 20))
    println("result = ${result}")
    result = lemonadeChange(intArrayOf(5, 5, 10))
    println("result = ${result}")
    result = lemonadeChange(intArrayOf(10, 10))
    println("result = ${result}")
    result = lemonadeChange(intArrayOf(5, 5, 10, 10, 20))
    println("result = ${result}")
}