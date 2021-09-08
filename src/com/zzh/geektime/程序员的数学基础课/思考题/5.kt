package com.zzh.geektime.程序员的数学基础课.思考题

import java.util.*
import kotlin.collections.ArrayList

fun resolve(total: Int, result: MutableList<Int>) {
    if (total == 1) {
        if (!result.contains(1)) {
            result.add(1)
        }
        println(result)
    } else {
        for (i in 1..total) {
            if (i == 1 && result.contains(1)) continue
            if (total % i != 0) continue
            val newResult = ArrayList<Int>(result.size + 1)
            newResult.addAll(result)
            newResult.add(i)
            resolve(total / i, newResult)
        }
    }
}

fun main() {
    resolve(8, ArrayList())
}