package com.zzh.数据结构_邓俊辉.chapter1_绪论.D_算法分析

import com.zzh.util.ArrayUtils

fun main() {
    val array = arrayOf(4, 5, 2, 7, 8, 1, 3, 6)
    bubbleSort(array)
    ArrayUtils.print(array)
}

private fun bubbleSort(array: Array<Int>) {
    var n = array.size
    var swapped = false
    while (true) {
        for (i in 1 until n) {
            if (array[i] < array[i - 1]) {
                ArrayUtils.swap(array, i, i - 1)
                swapped = true
            }
        }
        if (swapped) {
            swapped = false
            n -= 1
        } else {
            break
        }
    }
//    while (n != 0) {
//        for (i in 1 until n) {
//            if (array[i] < array[i - 1]) {
//                ArrayUtils.swap(array, i, i - 1)
//            }
//        }
//        n -= 1
//    }
}