package com.zzh.leetcode.竞赛.周赛._357;

import org.junit.Assert;

import java.util.ArrayDeque;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1_finalString {
    public static void main(String[] args) {
        _1_finalString finalString = new _1_finalString();
        String s, ans;

        s = "poiinter";
        ans = finalString.finalString(s);
        Assert.assertEquals("ponter", ans);
    }

    public String finalString(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        boolean appendTail = true;
        for (char c : s.toCharArray()) {
            if (c == 'i') appendTail = !appendTail;
            else if (appendTail) deque.addLast(c);
            else deque.addFirst(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : deque) {
            sb.append(character);
        }
        if (!appendTail) sb.reverse();
        return sb.toString();
    }

    public String finalString1(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'i') {
                for (int j = 0, k = i - 1; j < k; j++, k--) {
                    char temp = sb.charAt(j);
                    sb.setCharAt(j, sb.charAt(k));
                    sb.setCharAt(k, temp);
                }
                sb.deleteCharAt(i--);
            }
        }
        return sb.toString();
    }
}
