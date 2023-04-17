package com.zzh.leetcode._701_800

import java.util.*
import kotlin.collections.ArrayList

val stack = Stack<Int>()
val ans = ArrayList<ArrayList<Int>>()

fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    stack.push(0)
    dfs(graph, 0, graph.size - 1)
    return ans
}

fun dfs(graph: Array<IntArray>, x: Int, n: Int) {
    if (x == n) {
        ans.add(ArrayList(stack))
        return
    }
    for (y in graph[x]) {
        stack.push(y)
        dfs(graph, y, n)
        stack.pop()
    }
}

fun main() {
//    var allPathsSourceTarget =
//        allPathsSourceTarget(arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(3), intArrayOf()))
//    println("allPathsSourceTarget = ${allPathsSourceTarget}")

    val allPathsSourceTarget =
        allPathsSourceTarget(
            arrayOf(
                intArrayOf(4, 3, 1),
                intArrayOf(3, 2, 4),
                intArrayOf(3),
                intArrayOf(4),
                intArrayOf()
            )
        )
    println("allPathsSourceTarget = ${allPathsSourceTarget}")
}