package com.zzh.leetcode._1201_1300;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1249_minRemoveToMakeValid {
    public static void main(String[] args) {
        _1249_minRemoveToMakeValid minRemoveToMakeValid = new _1249_minRemoveToMakeValid();
        String s, ans;

        s = "a)b(c)d";
        ans = minRemoveToMakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals(ans, "ab(c)d");

        s = "))((";
        ans = minRemoveToMakeValid.minRemoveToMakeValid(s);
        Assert.assertEquals(ans, "");
    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            switch (c) {
                case '(':
                    stack.push(i);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        sb.deleteCharAt(i--);
                    } else {
                        stack.pop();
                    }
                    break;
            }
        }
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

}
