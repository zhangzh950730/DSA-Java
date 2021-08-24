package com.zzh.leetcode.竞赛.single_week.two_hundred_and_fifty_five

fun findDifferentBinaryString(nums: Array<String>): String {
    val length = nums[0].length
    val candidate = mutableListOf<Int>()
    for (i in 0 until Math.pow(2.0, length.toDouble()).toInt()) {
        candidate.add(i)
    }
    for (num in nums) {
        var acc = 0
        for (i in 0 until length) {
            acc += (num[i].toInt() - 48) * Math.pow(2.0, (length - i - 1).toDouble()).toInt()
        }
        candidate.remove(acc)
    }

    var resultNum = candidate.first()
    val resultBinaryString = StringBuilder()
    for (i in 0 until length - 1) {
        resultBinaryString.append(resultNum % 2)
        resultNum /= 2
    }
    resultBinaryString.append(resultNum)
    return resultBinaryString.toString().reversed()
}

fun main() {
    var findDifferentBinaryString = findDifferentBinaryString(arrayOf("01", "10"))
    println("findDifferentBinaryString = ${findDifferentBinaryString}")

    findDifferentBinaryString = findDifferentBinaryString(arrayOf("00", "01"))
    println("findDifferentBinaryString = ${findDifferentBinaryString}")

    findDifferentBinaryString = findDifferentBinaryString(arrayOf("111", "011"))
    println("findDifferentBinaryString = ${findDifferentBinaryString}")

    findDifferentBinaryString = findDifferentBinaryString(arrayOf("00", "01"))
    println("findDifferentBinaryString = ${findDifferentBinaryString}")
}

