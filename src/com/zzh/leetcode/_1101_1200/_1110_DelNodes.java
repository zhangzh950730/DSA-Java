package com.zzh.leetcode._1101_1200;

import org.apache.xpath.operations.And;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1110_DelNodes {

    public static void main(String[] args) {
        _1110_DelNodes delNodes = new _1110_DelNodes();
        List<TreeNode> list;

        TreeNode root = new TreeNode(1
                , new TreeNode(2, new TreeNode(4), new TreeNode(5))
                , new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        list = delNodes.delNodes(root, new int[]{3, 5});
        System.out.println("list = " + list);

        root = new TreeNode(1
                , new TreeNode(2, null, new TreeNode(3))
                , new TreeNode(4));
        list = delNodes.delNodes(root, new int[]{3});
        System.out.println("list = " + list);

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int toDelete : to_delete) set.add(toDelete);
        if (dfs(ans, set, root) != null) ans.add(root);
        return ans;
    }

    private TreeNode dfs(List<TreeNode> ans, HashSet<Integer> set, TreeNode root) {
        if (root == null) return null;

        // 更新当前节点的左右子节点
        root.left = dfs(ans, set, root.left);
        root.right = dfs(ans, set, root.right);

        // 当前节点没被删除, 返回当前节点
        if (!set.contains(root.val)) return root;

        // 当前节点被删除, 将其左右子节点加入ans中
        if (root.left != null) ans.add(root.left);
        if (root.right != null) ans.add(root.right);

        // 当前节点被删除, 返回null
        return null;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}


