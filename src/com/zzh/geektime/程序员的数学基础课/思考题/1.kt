package com.zzh.geektime.程序员的数学基础课.思考题

import kotlin.test.assertEquals

fun decimalToBinary(decimal: Int): String {
    var raw = decimal
    val ans = StringBuilder()
    while (raw != 0) {
        ans.append(raw % 2)
        raw = raw shr 1
    }
    return ans.toString()
}

fun main() {
    var decimalToBinary = decimalToBinary(5)
    assertEquals(decimalToBinary, "101")
    decimalToBinary = decimalToBinary(7)
    assertEquals(decimalToBinary, "111")

}