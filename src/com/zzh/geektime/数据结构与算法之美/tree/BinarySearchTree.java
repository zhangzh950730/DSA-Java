package com.zzh.geektime.数据结构与算法之美.tree;


/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/1 22:48
 */
public class BinarySearchTree {
    private TreeNode tree;

    public BinarySearchTree(TreeNode tree) {
        this.tree = tree;
    }

    public TreeNode find(int data) {
        TreeNode p = tree;
        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (p.data < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }
        TreeNode p = tree;
        while (true) {
            if (p.data < data) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        TreeNode p = tree;
        TreeNode pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (p.data < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }

        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    public TreeNode findMin() {
        TreeNode p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public TreeNode findMax() {
        TreeNode p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }


    public static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode node_33 = new TreeNode(33);

        TreeNode node_17 = new TreeNode(17);
        TreeNode node_50 = new TreeNode(50);
        node_33.left = node_17;
        node_33.right = node_50;

        TreeNode node_13 = new TreeNode(13);
        TreeNode node_18 = new TreeNode(18);
        node_17.left = node_13;
        node_17.right = node_18;
        TreeNode node_34 = new TreeNode(34);
        TreeNode node_58 = new TreeNode(58);
        node_50.left = node_34;
        node_50.right = node_58;

        TreeNode node_16 = new TreeNode(16);
        node_13.right = node_16;
        TreeNode node_25 = new TreeNode(25);
        node_18.right = node_25;
        TreeNode node_51 = new TreeNode(51);
        TreeNode node_66 = new TreeNode(66);
        node_58.left = node_51;
        node_58.right = node_66;

        TreeNode node_19 = new TreeNode(19);
        TreeNode node_27 = new TreeNode(27);
        node_25.left = node_19;
        node_25.right = node_27;

        BinarySearchTree binarySearchTree = new BinarySearchTree(node_33);
        TreeNode treeNode = binarySearchTree.find(19);
        System.out.println(treeNode);

        binarySearchTree.insert(55);
        System.out.println(binarySearchTree.tree);

        //binarySearchTree = new BinarySearchTree(null);
        //binarySearchTree.insert(55);
        //System.out.println(binarySearchTree.tree);

        binarySearchTree = new BinarySearchTree(new TreeNode(33));
        binarySearchTree.tree.left = new TreeNode(16);
        binarySearchTree.tree.right = new TreeNode(50);

        binarySearchTree.tree.left.left = new TreeNode(13);
        binarySearchTree.tree.left.right = new TreeNode(18);

        binarySearchTree.tree.right.left = new TreeNode(34);
        binarySearchTree.tree.right.right = new TreeNode(58);

        binarySearchTree.tree.left.left.right = new TreeNode(15);
        binarySearchTree.tree.left.right.left = new TreeNode(17);
        binarySearchTree.tree.left.right.right = new TreeNode(25);
        binarySearchTree.tree.right.right.left = new TreeNode(51);
        binarySearchTree.tree.right.right.right = new TreeNode(66);

        binarySearchTree.tree.left.right.right.left = new TreeNode(19);
        binarySearchTree.tree.left.right.right.right = new TreeNode(27);
        binarySearchTree.tree.right.right.left.right = new TreeNode(55);

        TreeNode min = binarySearchTree.findMin();
        System.out.println("min = " + min);
        TreeNode max = binarySearchTree.findMax();
        System.out.println("max = " + max);

        binarySearchTree.delete(13);
        binarySearchTree.delete(18);
        binarySearchTree.delete(55);
    }
}
