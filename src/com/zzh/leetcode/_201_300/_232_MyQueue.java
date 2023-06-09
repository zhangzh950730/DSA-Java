package com.zzh.leetcode._201_300;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _232_MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        Assert.assertEquals(myQueue.peek(), 1);
        Assert.assertEquals(myQueue.pop(), 1);
        Assert.assertFalse(myQueue.empty());
    }

    static class MyQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.empty()) inToOut();
            return outStack.pop();
        }

        public int peek() {
            if (outStack.empty()) inToOut();
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.empty() && outStack.empty();
        }

        private void inToOut() {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }

    }

}
