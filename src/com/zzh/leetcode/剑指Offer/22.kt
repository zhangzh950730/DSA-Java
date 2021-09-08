package com.zzh.leetcode.剑指Offer

import kotlin.test.assertEquals

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * 快慢指针
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
    var fast = head
    var slow = head
    var i = k
    while (fast != null && i > 0) {
        i--
        fast = fast.next
    }
    while (fast != null) {
        fast = fast.next
        slow = slow!!.next
    }
    return slow
}

/**
 * 顺序查找
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */
fun getKthFromEnd2(head: ListNode?, k: Int): ListNode? {
    var count = 0
    var p = head
    while (p != null) {
        p = p.next
        count++
    }
    p = head
    while (count > k) {
        p = p!!.next
        count--
    }
    return p
}

/**
 * 顺序表存储
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */
fun getKthFromEnd1(head: ListNode?, k: Int): ListNode? {
    if (head == null) {
        return null
    }
    val list = ArrayList<ListNode>(1)
    var p = head
    while (p != null) {
        list.add(p)
        p = p.next
    }
    return list[list.size - k]
}

fun main() {
    val a = ListNode(1)
    val b = ListNode(2)
    val c = ListNode(3)
    val d = ListNode(4)
    val e = ListNode(5)
    a.next = b
    b.next = c
    c.next = d
    d.next = e
    val kthFromEnd = getKthFromEnd(a, 2)
    assertEquals(kthFromEnd!!.`val`, 4)
    assertEquals(kthFromEnd.next!!.`val`, 5)
}