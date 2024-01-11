package com.zzh.leetcode._2601_2700;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2696_minLength {

    public static void main(String[] args) {
        _2696_minLength minLength = new _2696_minLength();
        int ans = minLength.minLength("ABFCACDB");
        Assert.assertEquals(ans, 2);
    }

    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push(' ');
        for (char c : s.toCharArray()) {
            if ((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C')) {
                stack.pop();
            } else stack.push(c);
        }
        return stack.size() - 1;
    }

}
