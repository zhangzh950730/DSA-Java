package com.zzh.leetcode._201_300;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _225_MyStack {

    static class MyStack {
        private final Deque<Integer> deque;

        public MyStack() {
            deque = new ArrayDeque<>();
        }

        public void push(int x) {
            deque.offerFirst(x);
        }

        public int pop() {
            return deque.poll();
        }

        public int top() {
            return deque.peek();
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }

    public static void main(String[] args) {

    }
}
