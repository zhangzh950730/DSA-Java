package com.zzh.leetcode.`701-800`

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val INF = 10000 * 101 + 1 // 上界
    var f = IntArray(n) { INF }
    f[src] = 0
    var ans = INF
    for (t in 1..k + 1) {
        val g = IntArray(n) { INF }
        for (flight in flights) {
            val j = flight[0]
            val i = flight[1]
            val cost = flight[2]
            g[i] = Math.min(g[i], f[j] + cost)
        }
        f = g
        ans = Math.min(ans, f[dst])
    }
    return if (ans == INF) -1 else ans
}

fun main() {
    val flights = arrayOf(intArrayOf(0, 1, 100), intArrayOf(1, 2, 200), intArrayOf(0, 2, 500))
    val findCheapestPrice = findCheapestPrice(3, flights, 0, 2, 1)
    println("findCheapestPrice = ${findCheapestPrice}")
}