package com.zzh.leetcode._001_100;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _20_isValid {
    public static void main(String[] args) {
        _20_isValid isValid = new _20_isValid();
        String s;
        boolean ans;

        s = "()";
        ans = isValid.isValid(s);
        Assert.assertTrue(ans);

        s = "()[]{}";
        ans = isValid.isValid(s);
        Assert.assertTrue(ans);

        s = "(]";
        ans = isValid.isValid(s);
        Assert.assertFalse(ans);

        s = "[";
        ans = isValid.isValid(s);
        Assert.assertFalse(ans);

        s = "((";
        ans = isValid.isValid(s);
        Assert.assertFalse(ans);

        s = "]";
        ans = isValid.isValid(s);
        Assert.assertFalse(ans);
    }

    public boolean isValid(String s) {
        s = s.replaceAll(" ", "");
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                case '[':
                case '{':
                    stack.push(aChar);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.empty();
    }

}
