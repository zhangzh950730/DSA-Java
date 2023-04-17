package com.zzh.leetcode._501_600

import java.util.*
import kotlin.collections.ArrayList
import kotlin.test.assertEquals

fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
    val list = ArrayList<IntArray>()
    val n = profits.size
    for (i in 0 until n) {
        list.add(intArrayOf(capital[i], profits[i]))
    }
    Collections.sort(list, { a, b -> a[0] - b[0] })
    val maxHeap = PriorityQueue<Int> { a, b -> b - a }
    var i = 0
    var p = k
    var ans = w
    while (p-- > 0) {
        while (i < n && list[i][0] <= ans) {
            maxHeap.add(list[i++][1])
        }
        if (maxHeap.isEmpty()) {
            break
        }
        ans += maxHeap.poll()
    }
    return ans
}

fun main() {
    var findMaximizedCapital =
        findMaximizedCapital(k = 2, w = 0, profits = intArrayOf(1, 2, 3), capital = intArrayOf(0, 1, 1))
    assertEquals(findMaximizedCapital, 4)
    findMaximizedCapital =
        findMaximizedCapital(k = 3, w = 0, profits = intArrayOf(1, 2, 3), capital = intArrayOf(0, 1, 2))
    assertEquals(findMaximizedCapital, 6)

}