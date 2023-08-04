package com.zzh.leetcode._601_700;

import org.junit.Assert;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _692_topKFrequent {

    public static void main(String[] args) {
        _692_topKFrequent topKFrequent = new _692_topKFrequent();
        String[] words;
        List<String> ans;
        int k;

        words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        k = 2;
        ans = topKFrequent.topKFrequent(words, k);
        Assert.assertEquals(ans.get(0), "i");
        Assert.assertEquals(ans.get(1), "love");

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.merge(word, 1, Integer::sum);

        // 频率最高 小顶堆
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int ans = map.get(o1).compareTo(map.get(o2)); // 次数少的放在堆顶
            if (ans != 0) return ans;
            return o2.compareTo(o1); // 字典序大的放在堆顶
        });

        int i = 0;
        for (String key : map.keySet()) {
            if (i++ < k) pq.offer(key);
            else if (pq.comparator().compare(key, pq.peek()) > 0) {
                pq.poll();
                pq.offer(key);
            }
        }
        List<String> ans = new LinkedList<>();
        while (!pq.isEmpty()) {
            ans.add(0, pq.poll());
        }
        return ans;
    }

}
