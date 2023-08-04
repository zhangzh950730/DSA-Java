package com.zzh.leetcode._801_900;

import org.junit.Assert;
import org.springframework.validation.annotation.Validated;
import org.yaml.snakeyaml.events.Event;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _895_FreqStack {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);

        int ans;
        ans = freqStack.pop();
        Assert.assertEquals(5, ans);

        ans = freqStack.pop();
        Assert.assertEquals(7, ans);

        ans = freqStack.pop();
        Assert.assertEquals(5, ans);

        ans = freqStack.pop();
        Assert.assertEquals(4, ans);
    }

    static class FreqStack {
        final Map<Integer, Integer> counter;
        final List<Deque<Integer>> stackList;

        public FreqStack() {
            counter = new HashMap<>();
            stackList = new ArrayList<>();
        }

        public void push(int val) {
            Integer count = counter.getOrDefault(val, 0);
            if (count == stackList.size()) {
                stackList.add(new ArrayDeque<>());
            }
            stackList.get(count).push(val);
            counter.put(val, count + 1);
        }

        public int pop() {
            int top = stackList.size() - 1;
            Deque<Integer> stack = stackList.get(top);
            Integer val = stack.pop();
            if (stack.isEmpty()) stackList.remove(top);
            counter.put(val, counter.get(val) - 1);
            return val;
        }
    }

}
