package com.zzh.leetcode.`701-800`

/**
 * @author zhangzhihao
 * @date 2020/12/15 8:36
 */
fun monotoneIncreasingDigits(N: Int): Int {
    val strN = N.toString().toCharArray()
    var i = 1
    while (i < strN.size && strN[i - 1] <= strN[i]) {
        i++
    }
    if (i < strN.size) {
        while (i > 0 && strN[i - 1] > strN[i]) {
            strN[i - 1] = strN[i - 1] - 1
            i -= 1
        }
        for (j in i + 1 until strN.size) {
            strN[j] = '9'
        }
    }
    return String(strN).toInt()
}

fun main() {
    var result = monotoneIncreasingDigits(10)
    println("result = ${result}")
    result = monotoneIncreasingDigits(1234)
    println("result = ${result}")
    result = monotoneIncreasingDigits(332)
    println("result = ${result}")
}