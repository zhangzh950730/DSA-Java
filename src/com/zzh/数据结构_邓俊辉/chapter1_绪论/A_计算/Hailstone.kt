package com.zzh.数据结构_邓俊辉.chapter1_绪论.A_计算

import java.util.*

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/17 22:32
 */

fun main() {
    var hailstone = hailstone(42)
    println(hailstone)
    hailstone = hailstone(7)
    println(hailstone)
    hailstone = hailstone(27)
    println(hailstone)
    hailstone = hailstone(63434)
    println(hailstone)
    var n = 1
    while (true) {
        hailstone = hailstone(n++)
        println(n.toString() + " : " + hailstone.size)
    }
}

fun hailstone(N: Int): List<Int> {
    var n = N
    val result = ArrayList<Int>()
    while (n > 1) {
        if (n % 2 == 0) {
            n /= 2
        } else {
            n = 3 * n + 1
        }
        result.add(n)
    }
    return result
}


