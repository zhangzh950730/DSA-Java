package com.zzh.leetcode

import java.time.format.ResolverStyle
import kotlin.math.pow

/**
 * @author zhangzhihao
 * @date 2020/12/14 10:17
 */

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()
    for (str in strs) {
        val charArray = str.toCharArray().sortedArray()
        val key = String(charArray)
        val value = map.getOrDefault(key, mutableListOf())
        value.add(str)
        map[key] = value
    }
    return ArrayList(map.values)
}

fun main() {
    var result = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    println(result)
    result = groupAnagrams(arrayOf("cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"))
    println(result)
    result = groupAnagrams(arrayOf("run", "had", "lot", "kim", "fat", "net", "fin", "rca", "chi", "lei", "lox", "iva", "liz", "hug", "hot", "irk", "lap", "tan", "tux", "yuk", "hep", "map", "ran", "ell", "kit", "put", "non", "aol", "add", "lad", "she", "job", "mes", "pen", "vic", "fag", "bud", "ken", "nod", "jam", "coy", "hui", "sue", "nap", "ton", "coy", "rut", "fit", "cut", "eta", "our", "oho", "zip"))
    println(result)
}