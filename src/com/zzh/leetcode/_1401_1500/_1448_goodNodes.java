package com.zzh.leetcode._1401_1500;

import com.zzh.leetcode.TreeNode;
import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1448_goodNodes {

    public static void main(String[] args) {
        _1448_goodNodes goodNodes = new _1448_goodNodes();
        TreeNode root;
        int ans;

        root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        ans = goodNodes.goodNodes(root);
        Assert.assertEquals(4, ans);


    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode treeNode, int maxVal) {
        if (treeNode == null) return 0;
        int left = dfs(treeNode.left, Math.max(maxVal, treeNode.val));
        int right = dfs(treeNode.right, Math.max(maxVal, treeNode.val));
        return left + right + (maxVal <= treeNode.val ? 1 : 0);
    }

}
