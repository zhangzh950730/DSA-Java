package com.zzh.leetcode._2301_2400;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _2381_shiftingLetters {
    public static void main(String[] args) {
        _2381_shiftingLetters shiftingLetters = new _2381_shiftingLetters();
        int[][] shifts = new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        String ans = shiftingLetters.shiftingLetters("abc", shifts);
        Assert.assertEquals("ace", ans);
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[] diff = new int[len + 1];
        for (int[] shift : shifts) {
            int left = shift[0], right = shift[1], dir = shift[2] * 2 - 1;
            diff[left] += dir;
            diff[right + 1] -= dir;
        }
        for (int i = 1; i < len; i++) {
            diff[i] += diff[i - 1];
        }

        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            int shift = c - 'a' + (diff[i] % 26) + 26;
            cs[i] = (char) (shift % 26 + 'a');
        }
        return new String(cs);
    }
}
