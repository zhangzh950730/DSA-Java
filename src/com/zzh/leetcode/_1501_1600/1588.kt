package com.zzh.leetcode._1501_1600

import org.junit.Assert.assertEquals

/**
 * O(n^3)
 */
fun sumOddLengthSubarrays1(arr: IntArray): Int {
    var sum = 0
    for (start in arr.indices) {
        var length = 1
        while (start + length <= arr.size) {
            val end = start + length - 1
            for (i in start..end) {
                sum += arr[i]
            }
            length += 2
        }
    }
    return sum
}

/**
 * O(n^2)
 */
fun sumOddLengthSubarrays2(arr: IntArray): Int {
    var sum = 0
    val prefixSums = IntArray(arr.size + 1)
    for (i in arr.indices) {
        prefixSums[i + 1] = arr[i] + prefixSums[i]
    }
    for (start in arr.indices) {
        var length = 1
        while (start + length <= arr.size) {
            val end = start + length - 1
            sum += prefixSums[end + 1] - prefixSums[start]
            length += 2
        }
    }
    return sum
}

/**
 * O(n)
 */
fun sumOddLengthSubarrays(arr: IntArray): Int {
    var sum = 0
    for (i in arr.indices) {
        val leftCount = i
        val rightCount = arr.size - i - 1
        val leftOdd = (leftCount + 1) / 2
        val rightOdd = (rightCount + 1) / 2
        val leftEven = leftCount / 2 + 1
        val rightEven = rightCount / 2 + 1
        sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
    }
    return sum
}

fun main() {
    var sumOddLengthSubarrays = sumOddLengthSubarrays(intArrayOf(1, 4, 2, 5, 3))
    assertEquals(sumOddLengthSubarrays, 58)
//    sumOddLengthSubarrays = sumOddLengthSubarrays(intArrayOf(1, 2))
//    assertEquals(sumOddLengthSubarrays, 3)
//    sumOddLengthSubarrays = sumOddLengthSubarrays(intArrayOf(10, 11, 12))
//    assertEquals(sumOddLengthSubarrays, 66)
}