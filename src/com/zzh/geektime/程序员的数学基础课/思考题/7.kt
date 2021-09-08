package com.zzh.geektime.程序员的数学基础课.思考题

import kotlin.collections.ArrayList

fun calLetterList(l: MutableList<String>, result: ArrayList<String>) {
    if (l.size == result.size) {
        println(result)
    } else {
        for (s in l) {
            val newResult = ArrayList<String>(result.size + 1)
            newResult.addAll(result)
            newResult.add(s)
            calLetterList(l, newResult)
        }
    }
}

fun main() {
    val l = mutableListOf("a", "b", "c", "d", "e")
    calLetterList(l, ArrayList())
}