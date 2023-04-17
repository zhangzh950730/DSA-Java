package com.zzh.leetcode._401_500

fun hammingDistance(x: Int, y: Int): Int {
    return countOnes(x xor y)
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
    var hammingDistance = hammingDistance(1, 4)
    println("hammingDistance = ${hammingDistance}")
    hammingDistance = hammingDistance(3, 1)
    println("hammingDistance = ${hammingDistance}")
}