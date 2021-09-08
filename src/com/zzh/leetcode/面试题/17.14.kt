package com.zzh.leetcode.面试题

import java.util.*

fun smallestK(arr: IntArray, k: Int): IntArray {
    if (k == 0) return IntArray(0)
    val heap = PriorityQueue<Int> { num1, num2 -> num2 - num1 }
    for (i in 0 until k) {
        heap.offer(arr[i])
    }
    for (i in k until arr.size) {
        if (heap.peek() > arr[i]) {
            heap.poll()
            heap.offer(arr[i])
        }
    }
    return heap.toIntArray()
}



fun main() {
    val smallestK = smallestK(intArrayOf(1, 3, 5, 7, 2, 4, 6, 8), 4)
}