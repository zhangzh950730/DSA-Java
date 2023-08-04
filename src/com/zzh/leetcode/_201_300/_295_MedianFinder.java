package com.zzh.leetcode._201_300;


import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _295_MedianFinder {

    public static void main(String[] args) {
        double ans;
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        ans = medianFinder.findMedian();
        Assert.assertEquals(1.5, ans, 0);

        medianFinder.addNum(3);

        ans = medianFinder.findMedian();
        Assert.assertEquals(2.0, ans, 0);

    }

    static class MedianFinder {
        private final PriorityQueue<Integer> minQue;
        private final PriorityQueue<Integer> maxQue;

        public MedianFinder() {
            minQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            maxQue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        }

        public void addNum(int num) {
            if (minQue.isEmpty() || num <= minQue.peek()) {
                minQue.offer(num);
                if (maxQue.size() + 1 < minQue.size()) {
                    maxQue.offer(minQue.poll());
                }
            } else {
                maxQue.offer(num);
                if (maxQue.size() > minQue.size()) {
                    minQue.offer(maxQue.poll());
                }
            }
        }

        public double findMedian() {
            if (minQue.isEmpty()) return 0.0;
            else if (minQue.size() > maxQue.size()) return minQue.peek();
            else return (minQue.peek() + maxQue.peek()) / 2.0;
        }
    }
}
