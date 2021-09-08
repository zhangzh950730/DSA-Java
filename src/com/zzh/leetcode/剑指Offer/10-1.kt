package com.zzh.leetcode.剑指Offer

import kotlin.test.assertEquals

fun fib(n: Int): Int {
    if (n <= 1) {
        return n
    }
    var p = 0
    var q = 1
    var r = 0
    val mod = 1000000007
    for (i in 2..n) {
        r = (p + q) % mod
        p = q
        q = r
    }
    return r
}

fun main() {
    var fib = fib(2)
    assertEquals(fib, 1)
    fib = fib(5)
    assertEquals(fib, 5)
    fib = fib(1)
    assertEquals(fib, 1)
}