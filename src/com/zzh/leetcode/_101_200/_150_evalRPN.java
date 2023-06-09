package com.zzh.leetcode._101_200;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _150_evalRPN {

    public static void main(String[] args) {
        _150_evalRPN evalRPN = new _150_evalRPN();
        String[] tokens;
        int ans;

        tokens = new String[]{"2", "1", "+", "3", "*"};
        ans = evalRPN.evalRPN(tokens);
        Assert.assertEquals(ans, 9);

        tokens = new String[]{"4", "13", "5", "/", "+"};
        ans = evalRPN.evalRPN(tokens);
        Assert.assertEquals(ans, 6);

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        ans = evalRPN.evalRPN(tokens);
        Assert.assertEquals(ans, 22);

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer num2 = numStack.pop();
                Integer num1 = numStack.pop();
                switch (token) {
                    case "+":
                        numStack.push(num1 + num2);
                        break;
                    case "-":
                        numStack.push(num1 - num2);
                        break;
                    case "*":
                        numStack.push(num1 * num2);
                        break;
                    case "/":
                        numStack.push(num1 / num2);
                        break;
                    default:
                }
            } else {
                numStack.push(Integer.valueOf(token));
            }
        }
        return numStack.pop();
    }

}
