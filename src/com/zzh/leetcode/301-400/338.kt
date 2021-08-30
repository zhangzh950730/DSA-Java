package com.zzh.leetcode.`301-400`

fun countBits(n: Int): IntArray {
    val bits = IntArray(n + 1)
    for (i in 0..n) {
        bits[i] = countOnes(i)
    }
    return bits
}

fun countOnes(i: Int): Int {
    var count = 0
    var num = i
    while (num != 0) {
        num = num and (num - 1)
        count++
    }
    return count
}


fun main() {
    var countBits = countBits(2)
    println("countBits = ${countBits}")
    countBits = countBits(5)
    println("countBits = ${countBits}")
}