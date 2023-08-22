package com.zzh.leetcode._2201_2300;

import com.zzh.leetcode.TreeNode;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2236_checkTree {

    public static void main(String[] args) {

    }

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}
