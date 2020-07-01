package com.zzh.geektime.数据结构与算法之美.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/1 21:30
 */
public class BinaryTree<T> {

    private void preOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        printNode(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        printNode(node);
        inOrder(node.right);
    }

    private void postOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        printNode(node);
    }

    private List<TreeNode<T>> floorLevelTree(TreeNode<T> root) {
        List<TreeNode<T>> result = new ArrayList<>();
        TreeNode<T> node = root;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            result.add(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }

    private void printNode(TreeNode<T> treeNode) {
        System.out.print(treeNode.data + " ");
    }

    public static void main(String[] args) {
        TreeNode<String> A = new TreeNode<>("A");
        TreeNode<String> B = new TreeNode<>("B");
        TreeNode<String> C = new TreeNode<>("C");

        A.left = B;
        A.right = C;
        B.left = new TreeNode<>("D");
        B.right = new TreeNode<>("E");
        C.left = new TreeNode<>("F");
        C.right = new TreeNode<>("G");

        BinaryTree<String> binaryTree = new BinaryTree<>();
        binaryTree.preOrder(A);
        System.out.println();
        binaryTree.inOrder(A);
        System.out.println();
        binaryTree.postOrder(A);
        System.out.println();
        List<TreeNode<String>> treeNodes = binaryTree.floorLevelTree(A);
        for (TreeNode<String> treeNode : treeNodes) {
            System.out.print(treeNode.data+" ");
        }
        System.out.println();

    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
