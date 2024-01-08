package com.zzh.leetcode._2401_2500;

import com.zzh.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2415_reverseOddLevels {
    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(2
                        , new TreeNode(3, new TreeNode(8), new TreeNode(13))
                        , new TreeNode(5, new TreeNode(21), new TreeNode(34)));
        _2415_reverseOddLevels reverseOddLevels = new _2415_reverseOddLevels();
        TreeNode ans = reverseOddLevels.reverseOddLevels(root);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = null;
            if (isOdd) list = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null && node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                if (isOdd) list.add(node);
            }

            if (isOdd) {
                for (int l = 0, r = size - 1; l < r; l++, r--) {
                    int temp = list.get(l).val;
                    list.get(l).val = list.get(r).val;
                    list.get(r).val = temp;
                }
            }
            isOdd ^= true;
        }
        return root;
    }
}
