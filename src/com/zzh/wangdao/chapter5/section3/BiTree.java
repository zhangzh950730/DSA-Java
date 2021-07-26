package com.zzh.wangdao.chapter5.section3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        System.out.print("preOrder: ");
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

    public void preOrder2() {
        System.out.print("preOrder2: ");
        Stack<BiTNode<T>> stack = new Stack<>();
        BiTNode<T> p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                visit(p);
                stack.push(p);
                p = p.lChild;
            } else {
                p = stack.pop();
                p = p.rChild;
            }
        }
        System.out.println();
    }

    public void inOrder() {
        System.out.print("inOrder: ");
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

    public void inOrder2() {
        System.out.print("inOrder2: ");
        Stack<BiTNode<T>> stack = new Stack<>();
        BiTNode<T> p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.lChild;
            } else {
                p = stack.pop();
                visit(p);
                p = p.rChild;
            }
        }
        System.out.println();
    }

    public void postOrder() {
        System.out.print("postOrder: ");
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

    public void postOrder2() {
        System.out.print("postOrder2: ");
        Stack<BiTNode<T>> stack = new Stack<>();
        BiTNode<T> p = root;
        BiTNode<T> r = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.lChild;
            } else {
                p = stack.peek();
                if (p.rChild != null && p.rChild != r) {
                    p = p.rChild;
                } else {
                    p = stack.pop();
                    visit(p);
                    r = p;
                    p = null;
                }
            }
        }
        System.out.println();
    }

    public void levelOrder() {
        System.out.print("levelOrder: ");
        Queue<BiTNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        BiTNode<T> p = null;
        while (!queue.isEmpty()) {
            p = queue.poll();
            visit(p);
            if (p.lChild != null) {
                queue.offer(p.lChild);
            }
            if (p.rChild != null) {
                queue.offer(p.rChild);
            }
        }
        System.out.println();
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
        tree.preOrder2();

        tree.inOrder();
        tree.inOrder2();

        tree.postOrder();
        tree.postOrder2();

        tree.levelOrder();

    }
}