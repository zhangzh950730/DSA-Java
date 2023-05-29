package com.zzh.leetcode._1401_1500;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _1419_MinNumberOfFrogs {
    public static void main(String[] args) {
        _1419_MinNumberOfFrogs minNumberOfFrogs = new _1419_MinNumberOfFrogs();
        int result = minNumberOfFrogs.minNumberOfFrogs("croakcroak");
        Assert.assertEquals(result, 1);
        result = minNumberOfFrogs.minNumberOfFrogs("crcoakroak");
        Assert.assertEquals(result, 2);
        result = minNumberOfFrogs.minNumberOfFrogs("croakcrook");
        Assert.assertEquals(result, -1);
    }

    // 数组比哈希表快。's' 保证 "croak" 中的任意字符都不会越界
    private static final char[] PREVIOUS = new char['s'];

    static { // 预处理每个字母在 "croak" 中的上一个字母
        var s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++)
            PREVIOUS[s[i]] = s[i - 1];
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        var cnt = new int['s'];
        for (var ch : croakOfFrogs.toCharArray()) {
            var pre = PREVIOUS[ch]; // pre 为 ch 在 "croak" 中的上一个字母
            if (cnt[pre] > 0) // 如果有青蛙发出了 pre 的声音
                cnt[pre]--; // 复用一只
            else if (ch != 'c') // 否则青蛙必须从 'c' 开始蛙鸣
                return -1; // 不符合要求
            cnt[ch]++; // 发出了 ch 的声音
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0)
            return -1; // 有发出其它声音的青蛙，不符合要求
        return cnt['k']; // 最后青蛙们都发出了 'k' 的声音
    }

}
