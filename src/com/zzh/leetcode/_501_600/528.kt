package com.zzh.leetcode._501_600

class Solution(w: IntArray) {
    var pre: IntArray
    var total: Int

    init {
        pre = IntArray(w.size)
        pre[0] = w[0]
        for (i in 1 until w.size) {
            pre[i] = pre[i - 1] + w[i]
        }
        total = w.sum()

        for (i in pre) {
            print("$i ")
        }
        println("pre = ${pre}")

        println("total = ${total}")
    }

    fun pickIndex(): Int {
        val x = (Math.random() * total).toInt() + 1
        println("x = ${x}")
        return binarySearch(x)
    }

    private fun binarySearch(x: Int): Int {
        var low = 0
        var high = pre.size - 1
        while (low < high) {
            val mid = (high - low) / 2 + low
            if (pre[mid] < x) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }
}

fun main() {
    val solution = Solution(intArrayOf(1, 3))
    var pickIndex = solution.pickIndex()
    println("pickIndex = ${pickIndex}")
    pickIndex = solution.pickIndex()
    println("pickIndex = ${pickIndex}")
    pickIndex = solution.pickIndex()
    println("pickIndex = ${pickIndex}")
    pickIndex = solution.pickIndex()
    println("pickIndex = ${pickIndex}")
    pickIndex = solution.pickIndex()
    println("pickIndex = ${pickIndex}")
}