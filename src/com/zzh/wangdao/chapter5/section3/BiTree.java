package com.zzh.wangdao.chapter5.section3;

/**
 * @author ZhangZhiHao
 * @date 2021/7/21 12:49
 */
public class BiTree<T> {
    public BiTNode<T> root;

    public BiTree(BiTNode<T> root) {
        this.root = root;
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(BiTNode<T> biTNode) {
        if (biTNode != null) {
            visit(biTNode);
            preOrder(biTNode.lChild);
            preOrder(biTNode.rChild);
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(BiTNode<T> biTNode) {
        if (biTNode != null) {
            inOrder(biTNode.lChild);
            visit(biTNode);
            inOrder(biTNode.rChild);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(BiTNode<T> biTNode) {
        if (biTNode != null) {
            postOrder(biTNode.lChild);
            postOrder(biTNode.rChild);
            visit(biTNode);
        }
    }

    private void visit(BiTNode<T> biTNode) {
        System.out.print(" " + biTNode.data);
    }

    public static class BiTNode<T> {
        public T data;
        public BiTNode<T> lChild;
        public BiTNode<T> rChild;

        public BiTNode(T data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        BiTNode<Integer> one = new BiTNode<>(1);
        BiTNode<Integer> two = new BiTNode<>(2);
        BiTNode<Integer> three = new BiTNode<>(3);
        BiTNode<Integer> four = new BiTNode<>(4);
        BiTNode<Integer> five = new BiTNode<>(5);
        BiTNode<Integer> six = new BiTNode<>(6);

        one.lChild = two;
        one.rChild = three;
        two.rChild = four;
        three.rChild = five;
        four.lChild = six;

        BiTree<Integer> biTree = new BiTree<>(one);
        biTree.preOrder();
        biTree.inOrder();
        biTree.postOrder();

        BiTNode<Character> A = new BiTNode<>('A');
        BiTNode<Character> B = new BiTNode<>('B');
        BiTNode<Character> C = new BiTNode<>('C');
        BiTNode<Character> D = new BiTNode<>('D');
        BiTNode<Character> E = new BiTNode<>('E');
        A.lChild = B;
        A.rChild = C;
        B.lChild = D;
        B.rChild = E;
        BiTree<Character> tree = new BiTree<>(A);
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
    }
}