package com.zzh.leetcode

import kotlin.math.min

class Solution {
    fun reverseStr(s: String, k: Int): String {
        val n = s.length
        val array = s.toCharArray()
        for (i in 0..n step 2 * k) {
            reverse(array, i, min(i + k, n) - 1)
        }
        return String(array)
    }

    private fun reverse(array: CharArray, lo: Int, hi: Int) {
        var left = lo
        var right = hi
        while (left < right) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left++
            right--
        }
    }
}