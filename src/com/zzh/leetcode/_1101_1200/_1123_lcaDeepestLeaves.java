package com.zzh.leetcode._1101_1200;

import com.zzh.leetcode.TreeNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1123_lcaDeepestLeaves {

    public static void main(String[] args) {
        _1123_lcaDeepestLeaves lcaDeepestLeaves = new _1123_lcaDeepestLeaves();

        TreeNode root = new TreeNode(3,
                new TreeNode(5, new TreeNode(6)
                        , new TreeNode(2, new TreeNode(7), new TreeNode(4)))
                , new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode ans = lcaDeepestLeaves.lcaDeepestLeaves(root);
        System.out.println("ans = " + ans);
    }


    private TreeNode ans;
    private Integer maxDepth = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, maxDepth);
        return ans;
    }

    private int dfs(TreeNode root, Integer depth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);
        if (left == right && left == maxDepth) {
            ans = root;
        }
        return Math.max(left, right);
    }

}
