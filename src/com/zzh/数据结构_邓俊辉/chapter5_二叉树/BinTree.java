package com.zzh.数据结构_邓俊辉.chapter5_二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * @author zhangzhihao
 * @date 2020/7/26 10:16
 */
public class BinTree<T> {
    protected int size;
    protected BinNode<T> root;

    /**
     * 更新节点高度
     */
    public int updateHeight(BinNode<T> x) {
        return x.height = 1 + Math.max(stature(x.lChild), stature(x.rChild));
    }

    /**
     * 更新节点及其祖先高度
     */
    public void updateHeightAbove(BinNode<T> x) {
        while (x != null) {
            updateHeight(x);
            x = x.parent;
        }
    }

    public BinNode<T> insertAsRC(BinNode<T> x, T e) {
        size++;
        x.insertAsRC(e);
        updateHeightAbove(x);
        return x.rChild;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return root != null;
    }

    public BinNode<T> root() {
        return root;
    }

    private int stature(BinNode<T> p) {
        return p != null ? p.height : -1;
    }

    /**
     * 先序遍历-递归版
     * 根节点->左子树->右子树
     */
    public void preOrder1(BinNode<T> x, Consumer<T> consumer) {
        if (x == null) {
            return;
        }
        consumer.accept(x.data);
        preOrder1(x.lChild, consumer);
        preOrder1(x.rChild, consumer);
    }

    /**
     * 先序遍历-迭代版1(借助栈)
     * 根节点->左子树->右子树
     */
    public void preOrder2(BinNode<T> x, Consumer<T> consumer) {
        Stack<BinNode<T>> stack = new Stack<>();
        stack.push(x);
        while (!stack.empty()) {
            x = stack.pop();
            consumer.accept(x.data);
            if (x.rChild != null) {
                stack.push(x.rChild);
            }
            if (x.lChild != null) {
                stack.push(x.lChild);
            }
        }
    }

    /**
     * 先序遍历-迭代版2(借助栈,左侧调用链)
     * 根节点->左子树->右子树
     */
    public void preOrder3(BinNode<T> x, Consumer<T> consumer) {
        Stack<BinNode<T>> stack = new Stack<>();
        while (true) {
            visitAlongLeftBranch(x, consumer, stack);
            if (stack.empty()) {
                break;
            }
            x = stack.pop();
        }
    }

    private void visitAlongLeftBranch(BinNode<T> x, Consumer<T> consumer, Stack<BinNode<T>> stack) {
        while (x != null) {
            consumer.accept(x.data);
            stack.push(x.rChild);
            x = x.lChild;
        }
    }

    /**
     * 左子树->根节点->右子树
     */
    public void inOrder(BinNode<T> x, Consumer<T> consumer) {
        Stack<BinNode<T>> stack = new Stack<>();
        while (true) {
            goAlongLeftBranch(x, stack);
            if (stack.empty()) {
                break;
            }
            x = stack.pop();
            consumer.accept(x.data);
            x = x.rChild;
        }
    }

    private void goAlongLeftBranch(BinNode<T> x, Stack<BinNode<T>> stack) {
        while (x != null) {
            stack.push(x);
            x = x.lChild;
        }
    }

    /**
     * 左子树->右子树->根节点
     */
    public void postOrder() {

    }

    /**
     * 层次遍历
     */
    public void travLevel(Consumer<T> consumer) {
        Queue<BinNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinNode<T> x = queue.poll();
            consumer.accept(x.data);
            if (x.lChild != null) {
                queue.offer(x.lChild);
            }
            if (x.rChild != null) {
                queue.offer(x.rChild);
            }
        }
    }
}
