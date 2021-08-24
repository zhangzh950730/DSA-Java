package com.zzh.leetcode.竞赛.双周赛.`59`

class Solution {

    fun minTimeToType(word: String): Int {
        val alphabet = mutableListOf<Char>()
        for (char in 'a'..'z') {
            alphabet.add(char)
        }
        var count = 0
        var index = 0
        val chars = word.toCharArray()
        for (char in chars) {
            val currentIndex = char - 'a'
            val flag: Boolean
            val distance: Int
            if (index < currentIndex) {
                val order = currentIndex - index
                val reverseOrder = 0 - (currentIndex - index - 26)
                distance = if (order < reverseOrder) {
                    flag = true
                    order
                } else {
                    flag = false
                    reverseOrder
                }
            } else if (currentIndex < index) {
                val order = 0 - (index - currentIndex - 26)
                val reverseOrder = 0 - (currentIndex - index)
                distance = if (order < reverseOrder) {
                    flag = true
                    order
                } else {
                    flag = false
                    reverseOrder
                }
            } else {
                distance = 0
                flag = true
            }
            count += distance
            count += 1
            if (flag) {
                index += distance
                if (index >= 26) {
                    index -= 26
                }
            } else {
                if (index < distance) {
                    index = index - distance + 26
                } else {
                    index -= distance
                }
            }
        }
        return count
    }

}

fun main() {
    val solution = Solution()
    var minTimeToType = solution.minTimeToType("abc")
    println("minTimeToType = ${minTimeToType}")
    minTimeToType = solution.minTimeToType("bza")
    println("minTimeToType = ${minTimeToType}")
    minTimeToType = solution.minTimeToType("zjpc")
    println("minTimeToType = ${minTimeToType}")
    minTimeToType = solution.minTimeToType("pdy")
    println("minTimeToType = ${minTimeToType}")
}