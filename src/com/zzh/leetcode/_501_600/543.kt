package com.zzh.leetcode._501_600

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

var ans: Int = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    ans = 1
    dfs(root)
    return ans - 1
}

fun dfs(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val L = dfs(root.left)
    val R = dfs(root.right)
    ans = Math.max(ans, L + R + 1)
    return Math.max(L, R) + 1
}
