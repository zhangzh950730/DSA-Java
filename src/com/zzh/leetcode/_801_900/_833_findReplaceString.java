package com.zzh.leetcode._801_900;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _833_findReplaceString {
    public static void main(String[] args) {
        _833_findReplaceString findReplaceString = new _833_findReplaceString();
        String s, ans;
        int[] indices;
        String[] sources, targets;

        s = "abcd";
        indices = new int[]{0, 2};
        sources = new String[]{"a", "cd"};
        targets = new String[]{"eee", "ffff"};
        ans = findReplaceString.findReplaceString(s, indices, sources, targets);
        Assert.assertEquals("eeebffff", ans);

//        s = "abcd";
//        indices = new int[]{0, 2};
//        sources = new String[]{"ab", "ec"};
//        targets = new String[]{"eee", "ffff"};
//        ans = findReplaceString.findReplaceString(s, indices, sources, targets);
//        Assert.assertEquals("eeecd", ans);

    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        String[] replaceStr = new String[n];
        int[] replaceLen = new int[n];
        Arrays.fill(replaceLen, 1);
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (s.startsWith(sources[i], index)) {
                replaceStr[index] = targets[i];
                replaceLen[index] = sources[i].length();
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i += replaceLen[i]) {
            if (replaceStr[i] == null) {
                ans.append(s.charAt(i));
            } else {
                ans.append(replaceStr[i]);
            }
        }
        return ans.toString();
    }

}
