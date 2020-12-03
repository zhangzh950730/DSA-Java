package com.zzh.leetcode

import java.util.*

/**
 * @author zhangzhihao
 * @date 2020/12/3 11:12
 */
/**
 * 1.枚举法
 */
fun countPrimes2(n: Int): Int {
    var count = 0
    for (i in 2 until n) {
        if (isPrime(i)) count++
    }
    return count
}

fun isPrime(x: Int): Boolean {
    var i = 2
    while (i * i <= x) {
        if (x % i == 0) {
            return false
        }
        i++
    }
    return true
}

/**
 * 埃氏筛
 */
fun countPrimes1(n: Int): Int {
    val isPrime = Array(n) { 1 }
    var count = 0
    for (i in 2 until n) {
        if (isPrime[i] == 1) {
            count++
            if (i * i.toLong() < n) {
                var j = i * i
                while (j < n) {
                    isPrime[j] = 0
                    j += i
                }
            }
        }
    }
    return count
}

/**
 * 线性筛
 */
fun countPrimes(n: Int): Int {
    val primes = mutableListOf<Int>()
    val isPrime = Array(n) { 1 }
    for (i in 2 until n) {
        if (isPrime[i] == 1) {
            primes.add(i)
        }
        var j = 0
        while (j < primes.size && i * primes[j] < n) {
            isPrime[i * primes[j]] = 0
            if (i % primes[j] == 0) {
                break
            }
            j++
        }
    }
    return primes.size
}

fun main() {
    var result = countPrimes(10)
    println("result = ${result}")
    result = countPrimes(0)
    println("result = ${result}")
    result = countPrimes(1)
    println("result = ${result}")
    result = countPrimes(3)
    println("result = ${result}")
    result = countPrimes(499979)
    println("result = ${result}")
}