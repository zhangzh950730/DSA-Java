package com.zzh.leetcode.`001-100`


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

val list = mutableListOf<Int>()

fun inorderTraversal(root: TreeNode?): List<Int> {
    inorder(root)
    return list
}

fun inorder(root: TreeNode?) {
    if (root != null) {
        inorder(root.left)
        list.add(root.`val`)
        inorder(root.right)
    }
}

fun main() {
}