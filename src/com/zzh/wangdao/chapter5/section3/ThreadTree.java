package com.zzh.wangdao.chapter5.section3;

public class ThreadTree<T> {
    public ThreadNode<T> root;

    public ThreadTree(ThreadNode<T> root) {
        this.root = root;
    }

    public static class ThreadNode<T> {
        public T data;
        public ThreadNode<T> lChild, rChild;
        public int lTag, rTag;

        public ThreadNode(T data) {
            this.data = data;
        }
    }

    public void createInThread() {

    }

    private ThreadNode<T> inThread(ThreadNode<T> p, ThreadNode<T> pre) {
        // TODO: 2021/7/26
        return null;
    }

    public static void main(String[] args) {
        ThreadNode<Character> A = new ThreadNode<>('A');
        ThreadNode<Character> B = new ThreadNode<>('B');
        ThreadNode<Character> C = new ThreadNode<>('C');
        ThreadNode<Character> D = new ThreadNode<>('D');
        ThreadNode<Character> E = new ThreadNode<>('E');
        ThreadNode<Character> G = new ThreadNode<>('G');
        A.lChild = B;
        A.rChild = C;
        B.lChild = D;
        B.rChild = E;
        C.rChild = G;
        ThreadTree<Character> threadTree = new ThreadTree<>(A);
        threadTree.createInThread();
        System.out.println("threadTree = " + threadTree);
    }
}
