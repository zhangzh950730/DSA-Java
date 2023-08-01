package com.zzh.leetcode._1401_1500;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1472_BrowserHistory {

    public static void main(String[] args) {

//        ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
//[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
//[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]


        String fb = "facebook.com";
        String lc = "leetcode.com";
        String gg = "google.com";
        String yb = "youtube.com";
        String li = "linkedin.com";

        String ans;
        BrowserHistory browserHistory = new BrowserHistory(lc);
        browserHistory.visit(gg);
        browserHistory.visit(fb);
        browserHistory.visit(yb);
        ans = browserHistory.back(1);
        Assert.assertEquals(fb, ans);

        ans = browserHistory.back(1);
        Assert.assertEquals(gg, ans);

        ans = browserHistory.forward(1);
        Assert.assertEquals(fb, ans);

        browserHistory.visit(li);

        ans = browserHistory.forward(2);
        Assert.assertEquals(li, ans);

        ans = browserHistory.back(2);
        Assert.assertEquals(gg, ans);

        ans = browserHistory.back(7);
        Assert.assertEquals(lc, ans);

    }

    static class BrowserHistory {
        private final Stack<String> backStack = new Stack<>();
        private final Stack<String> forwardStack = new Stack<>();

        public BrowserHistory(String homepage) {
            backStack.push(homepage);
        }

        public void visit(String url) {
            backStack.push(url);
            forwardStack.clear();
        }

        public String back(int steps) {
            for (int i = 0; i < steps && backStack.size() > 1; i++) {
                forwardStack.push(backStack.pop());
            }
            return backStack.peek();
        }

        public String forward(int steps) {
            for (int i = 0; i < steps && !forwardStack.isEmpty(); i++) {
                backStack.push(forwardStack.pop());
            }
            return backStack.peek();
        }
    }

}
