package com.zzh.leetcode._601_700;

import com.zzh.leetcode.TreeNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _617_mergeTrees {
    public static void main(String[] args) {
        _617_mergeTrees mergeTrees = new _617_mergeTrees();
        TreeNode root1, root2, ans;

        root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2, null, null));
        root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        ans = mergeTrees.mergeTrees(root1, root2);
        System.out.println("ans = " + ans);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        return new TreeNode(root1.val + root2.val, left, right);
    }
}


