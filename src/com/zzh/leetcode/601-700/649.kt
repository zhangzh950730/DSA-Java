package com.zzh.leetcode.`601-700`

import java.util.*

/**
 * @author zhangzhihao
 * @date 2020/12/11 9:15
 */

fun predictPartyVictory(senate: String): String {
    val radiant: Queue<Int> = LinkedList<Int>()
    val dire: Queue<Int> = LinkedList<Int>()
    for ((index, value) in senate.withIndex()) {
        if (value == 'R') radiant.offer(index)
        else dire.offer(index)
    }
    while (radiant.isNotEmpty() && dire.isNotEmpty()) {
        val r = radiant.poll()
        val d = dire.poll()
        if (r < d) {
            radiant.offer(r + senate.length)
        } else {
            dire.offer(d + senate.length)
        }
    }
    return if (radiant.isNotEmpty()) "Radiant"
    else "Dire"
}

fun main() {
    var win = predictPartyVictory("RD")
    println("win = ${win}")
    win = predictPartyVictory("RDD")
    println("win = ${win}")

}