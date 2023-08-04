package com.zzh.leetcode._701_800;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _767_reorganizeString {

    public static void main(String[] args) {
        _767_reorganizeString reorganizeString = new _767_reorganizeString();
        String s, ans;

        s = "aab";
        ans = reorganizeString.reorganizeString(s);
        Assert.assertEquals("aba", ans);

        s = "aaab";
        ans = reorganizeString.reorganizeString(s);
        Assert.assertEquals("", ans);

    }

    public String reorganizeString(String s) {
        if (s.length() < 2) return s;
        int[] counter = new int[26];
        int maxCount = 0;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            counter[index]++;
            maxCount = Math.max(maxCount, counter[index]);
        }
        if (maxCount > (s.length() + 1) / 2) return "";

        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> counter[o2 - 'a'] - counter[o1 - 'a']);
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 0) {
                int num = 'a' + i;
                pq.offer((char) num);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            Character o1 = pq.poll();
            Character o2 = pq.poll();
            sb.append(o1).append(o2);
            if (--counter[o1 - 'a'] > 0) pq.offer(o1);
            if (--counter[o2 - 'a'] > 0) pq.offer(o2);
        }
        if (!pq.isEmpty()) sb.append(pq.poll());
        return sb.toString();
    }

}
