package com.zzh.leetcode._401_500;

import com.zzh.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _449_Codec {

    public static void main(String[] args) {
        // Your Codec object will be instantiated and called as such:
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);
    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            postOrder(root, list);
            String str = list.toString();
            return str.substring(1, str.length() - 1);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            String[] arr = data.split(", ");
            Deque<Integer> stack = new ArrayDeque<>();
            for (String s : arr) {
                stack.push(Integer.valueOf(s));
            }
            return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
        }

        private void postOrder(TreeNode root, ArrayList<Integer> list) {
            if (root == null) return;
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }

        private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
            if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
                return null;
            }
            Integer val = stack.pop();
            TreeNode root = new TreeNode(val);
            root.right = construct(val, upper, stack);
            root.left = construct(lower, upper, stack);
            return root;
        }
    }
}
