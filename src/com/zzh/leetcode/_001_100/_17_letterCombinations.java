package com.zzh.leetcode._001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _17_letterCombinations {
    public static void main(String[] args) {
        _17_letterCombinations letterCombinations = new _17_letterCombinations();
        List<String> ans = letterCombinations.letterCombinations("23");
        System.out.println("ans = " + ans);
    }

    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private final List<String> ans = new ArrayList<>();
    private char[] digits, path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) return List.of();
        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        int j = digits[i] - '0';
        for (char c : MAPPING[j].toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }

}
