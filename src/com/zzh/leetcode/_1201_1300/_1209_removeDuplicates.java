package com.zzh.leetcode._1201_1300;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1209_removeDuplicates {

    public static void main(String[] args) {
        _1209_removeDuplicates removeDuplicates = new _1209_removeDuplicates();
        String s, ans;
        int k;

        s = "abcd";
        k = 2;
        ans = removeDuplicates.removeDuplicates(s, k);
        Assert.assertEquals(s, ans);

        s = "deeedbbcccbdaa";
        k = 3;
        ans = removeDuplicates.removeDuplicates(s, k);
        Assert.assertEquals("aa", ans);

        s = "pbbcggttciiippooaais";
        k = 2;
        ans = removeDuplicates.removeDuplicates(s, k);
        Assert.assertEquals("ps", ans);

    }

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> counter = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                counter.push(1);
            } else {
                int count = counter.pop() + 1;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i -= k;
                } else {
                    counter.push(count);
                }
            }
        }
        return sb.toString();
    }

}
