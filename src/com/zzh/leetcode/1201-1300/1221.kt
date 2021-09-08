package com.zzh.leetcode.`1201-1300`

import kotlin.test.assertEquals

fun balancedStringSplit(s: String): Int {
    val first = s.first()
    var count = 1
    var ans = 0
    for (i in 1 until s.length) {
        if (s[i] == first) count++
        else count--
        if (count == 0) ans++
    }
    return ans
}

fun main() {
    var balancedStringSplit = balancedStringSplit("RLRRLLRLRL")
    assertEquals(balancedStringSplit, 4)
    balancedStringSplit = balancedStringSplit("RLLLLRRRLR")
    assertEquals(balancedStringSplit, 3)
    balancedStringSplit = balancedStringSplit("LLLLRRRR")
    assertEquals(balancedStringSplit, 1)
    balancedStringSplit = balancedStringSplit("RLRRRLLRLL")
    assertEquals(balancedStringSplit, 2)
}