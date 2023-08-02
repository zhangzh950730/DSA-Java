package com.zzh.leetcode._2701_2800;

import org.junit.Assert;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2800_minimumString {

    public static void main(String[] args) {
        _2800_minimumString minimumString = new _2800_minimumString();
        String a = "abc", b = "bca", c = "aaa";
        String ans = minimumString.minimumString(a, b, c);
        Assert.assertEquals("aaabca", ans);
    }

    public String minimumString(String a, String b, String c) {
        String[][] strs = new String[][]{{a, b, c}, {a, c, b}, {b, a, c}, {b, c, a}, {c, a, b}, {c, b, a}};
        String ans = a.concat(b).concat(c);
        for (String[] str : strs) {
            String temp = merge(merge(str[0], str[1]), str[2]);
            if (temp.length() < ans.length() || temp.length() == ans.length() && temp.compareTo(ans) < 0) {
                ans = temp;
            }
        }
        return ans;
    }

    private String merge(String s1, String s2) {
        if (s1.contains(s2)) return s1;
        if (s2.contains(s1)) return s2;
        int n1 = s1.length(), n2 = s2.length();
        for (int i = Math.min(n1 - 1, n2 - 1); i >= 0; i--) {
            if (s1.substring(n1 - 1 - i).equals(s2.substring(0, i + 1))) {
                return s1.concat(s2.substring(i + 1));
            }
        }
        return s1.concat(s2);
    }

}
