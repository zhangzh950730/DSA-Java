package com.zzh.leetcode._101_200

import org.junit.Assert.assertEquals

/**
 * 双指针
 */
fun compareVersion(version1: String, version2: String): Int {
    val n = version1.length
    val m = version2.length
    var i = 0
    var j = 0
    while (i < n || j < m) {
        var x = 0
        while (i < n && version1[i] != '.') {
            x = x * 10 + (version1[i++] - '0')
        }
        i++

        var y = 0
        while (j < m && version2[j] != '.') {
            y = y * 10 + (version2[j++] - '0')
        }
        j++

        if (x != y) {
            return if (x > y) 1
            else -1
        }
    }
    return 0
}

/**
 * 分割字符串
 * 时间复杂度: O(max(n,m))
 * 空间复杂度: O(n+m)
 */
fun compareVersion1(version1: String, version2: String): Int {
    val v1 = version1.split(".")
    val v2 = version2.split(".")
    for (i in 0..Math.max(v1.size, v2.size)) {
        var x = 0
        var y = 0
        if (i < v1.size) {
            x = v1[i].toInt()
        }
        if (i < v2.size) {
            y = v2[i].toInt()
        }
        if (x < y) {
            return -1
        }
        if (x > y) {
            return 1
        }
    }
    return 0
}

fun main() {
    var compareVersion = compareVersion("1.01", "1.001")
    assertEquals(compareVersion, 0)
    compareVersion = compareVersion("1.0", "1.0.0")
    assertEquals(compareVersion, 0)
    compareVersion = compareVersion("0.1", "1.1")
    assertEquals(compareVersion, -1)
    compareVersion = compareVersion("1.0.1", "1")
    assertEquals(compareVersion, 1)
    compareVersion = compareVersion("7.5.2.4", "7.5.3")
    assertEquals(compareVersion, -1)
}