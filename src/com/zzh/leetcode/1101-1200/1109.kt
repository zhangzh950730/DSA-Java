package com.zzh.leetcode.`1101-1200`

fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val nums = IntArray(n)
    for (booking in bookings) {
        nums[booking[0] - 1] += booking[2]
        if (booking[1] < n) {
            nums[booking[1]] -= booking[2]
        }
    }
    for (i in 1 until n) {
        nums[i] += nums[i - 1]
    }
    return nums
}

fun corpFlightBookings1(bookings: Array<IntArray>, n: Int): IntArray {
    val array = IntArray(n)
    for (booking in bookings) {
        val first = booking[0]
        val last = booking[1]
        val seats = booking[2]
        for (i in first..last) {
            array[i - 1] += seats
        }
    }
    return array
}

fun main() {
    var corpFlightBookings =
        corpFlightBookings(arrayOf(intArrayOf(1, 2, 10), intArrayOf(2, 3, 20), intArrayOf(2, 5, 25)), n = 5)
    println("corpFlightBookings = ${corpFlightBookings}")
    corpFlightBookings = corpFlightBookings(arrayOf(intArrayOf(1, 2, 10), intArrayOf(2, 2, 15)), n = 2)
    println("corpFlightBookings = ${corpFlightBookings}")
}