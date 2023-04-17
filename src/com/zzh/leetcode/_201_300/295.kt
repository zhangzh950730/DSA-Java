package com.zzh.leetcode._201_300

import java.util.*

val queMin = PriorityQueue<Int> { a, b -> b - a }
val queMax = PriorityQueue<Int> { a, b -> a - b }

fun addNum(num: Int) {
    if (queMin.isEmpty() || num <= queMin.peek()) {
        queMin.offer(num)
        if (queMax.size + 1 < queMin.size) {
            queMax.offer(queMin.poll())
        }
    } else {
        queMax.offer(num)
        if (queMin.size < queMax.size) {
            queMin.offer(queMax.poll())
        }
    }
}

fun findMedian(): Double {
    return if (queMax.size < queMin.size) {
        queMin.peek().toDouble()
    } else {
        (queMin.peek() + queMax.peek()) / 2.0
    }
}

fun main() {
    addNum(1)
    addNum(2)
    var findMedian = findMedian()
    println("findMedian = ${findMedian}")
    addNum(3)
    findMedian = findMedian()
    println("findMedian = ${findMedian}")
}