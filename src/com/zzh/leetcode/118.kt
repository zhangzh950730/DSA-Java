package com.zzh.leetcode

/**
 * @author zhangzhihao
 * @date 2020/12/6 9:17
 */

fun generate(numRows: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    if (numRows == 0) return result
    result.add((listOf(1)))
    if (numRows == 1) return result
    result.add(listOf(1, 1))
    if (numRows == 2) return result
    for (i in 2 until numRows) {
        val list = ArrayList<Int>()
        result.add(list)
        list.add(1)
        for (j in 1 until i) {
            list.add(result[i - 1][j - 1] + result[i - 1][j])
        }
        list.add(1)
    }
    return result
}

fun main() {
    var result = generate(5)
    println("result = ${result}")
    result = generate(0)
    println("result = ${result}")
}