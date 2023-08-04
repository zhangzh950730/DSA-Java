package com.zzh.leetcode._301_400;

import org.junit.Assert;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _347_topKFrequent {

    public static void main(String[] args) {
        _347_topKFrequent topKFrequent = new _347_topKFrequent();
        int[] nums, ans;
        int k;

        nums = new int[]{1, 1, 1, 2, 2, 3};
        k = 2;
        ans = topKFrequent.topKFrequent(nums, k);
        Assert.assertArrayEquals(new int[]{1, 2}, ans);

        nums = new int[]{1};
        k = 1;
        ans = topKFrequent.topKFrequent(nums, k);
        Assert.assertArrayEquals(new int[]{1}, ans);

        nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        k = 2;
        ans = topKFrequent.topKFrequent(nums, k);
        Assert.assertArrayEquals(new int[]{-1, 2}, ans);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);

        // 统计频率最高, 使用小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    int ans = o1.getValue() - o2.getValue();
                    if (ans != 0) return ans;
                    else return o2.getKey() - o1.getKey();
                });

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i++ < k) {
                pq.offer(entry);
            } else if (pq.comparator().compare(entry, pq.peek()) > 0) { // 如果entry比peek排序结果大, 即值比peek值大
                pq.poll();
                pq.offer(entry);
            }
        }

        int[] ans = new int[k];
        for (i = k - 1; i >= 0 && !pq.isEmpty(); i--) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }


}
