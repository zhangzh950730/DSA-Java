package com.zzh.leetcode.`801-900`

fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sort()
    var lo = 0
    var hi = people.size - 1
    var ans = 0
    while (lo <= hi) {
        if (people[lo] + people[hi] <= limit) {
            lo++
        }
        hi--
        ans++
    }
    return ans
}

fun main() {
    var numRescueBoats = numRescueBoats(intArrayOf(1, 2), 3)
    println("numRescueBoats = ${numRescueBoats}")
    numRescueBoats = numRescueBoats(intArrayOf(3, 2, 2, 1), 3)
    println("numRescueBoats = ${numRescueBoats}")
    numRescueBoats = numRescueBoats(intArrayOf(3, 5, 3, 4), 5)
    println("numRescueBoats = ${numRescueBoats}")
}