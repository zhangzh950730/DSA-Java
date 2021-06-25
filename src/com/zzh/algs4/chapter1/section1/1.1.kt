package com.zzh.algs4.chapter1.section1_基础编程模型

/**
 *  1.1.24 1.1.25
 *
 * @author zhangzhihao
 * @date 2020/7/30 16:58
 */

fun main() {
    println(gcd(3, 5))
}

/**
 * 欧几里得算法,计算p和q的最大公约数
 */
fun gcd(p: Int, q: Int): Int {
    println("p = $p")
    println("q = $q")
    return if (q == 0) p else {
        gcd(q, p % q)
    }
}

