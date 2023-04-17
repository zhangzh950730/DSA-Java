package com.zzh.leetcode._201_300

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root != null) {
        val temp = root.left
        root.left = root.right
        root.right = temp
        invertTree(root.left)
        invertTree(root.right)
    }
    return root
}

fun main() {

}