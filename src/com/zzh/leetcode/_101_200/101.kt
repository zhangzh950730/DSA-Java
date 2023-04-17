package com.zzh.leetcode._101_200

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun isSymmetric(root: TreeNode?): Boolean {
    return check(root, root)
}

fun check(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }
    if (p == null || q == null) {
        return false
    }
    return p.`val` == q.`val` && check(p.left, q.right) && check(p.right, q.left)
}