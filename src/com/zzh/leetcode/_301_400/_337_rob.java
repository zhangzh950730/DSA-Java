package com.zzh.leetcode._301_400;

import com.zzh.leetcode.TreeNode;
import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _337_rob {

    public static void main(String[] args) {
        _337_rob rob = new _337_rob();
        TreeNode root;
        int ans;

        root = new TreeNode(3
                , new TreeNode(2, null, new TreeNode(3))
                , new TreeNode(3, null, new TreeNode(1)));
        ans = rob.rob(root);
        Assert.assertEquals(7, ans);
    }

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, notRob};
    }

}
