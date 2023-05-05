package com.zzh.leetcode._1001_1100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1062_MaxAncestorDiff {

    public static void main(String[] args) {
        _1062_MaxAncestorDiff maxAncestorDiff = new _1062_MaxAncestorDiff();
        TreeNode root = new TreeNode(8
                , new TreeNode(3, new TreeNode(1)
                , new TreeNode(6, new TreeNode(4), new TreeNode(7)))
                , new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
        int i = maxAncestorDiff.maxAncestorDiff(root);
        Assert.assertEquals(i, 7);

        root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));
        i = maxAncestorDiff.maxAncestorDiff(root);
        Assert.assertEquals(i, 3);

    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int min, int max) {
        if (root == null) return max - min;
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        if (root.left == null && root.right == null) {
            return max - min;
        }
        int leftDiff = dfs(root.left, min, max);
        int rightDiff = dfs(root.right, min, max);
        return Math.max(leftDiff, rightDiff);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
