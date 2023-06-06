package com.zzh.leetcode._201_300;

import org.junit.Assert;

import java.util.PriorityQueue;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _215_findKthLargest {

    public static void main(String[] args) {
        _215_findKthLargest findKthLargest = new _215_findKthLargest();
        int[] nums;
        int k, ans;

        nums = new int[]{3, 2, 1, 5, 6, 4};
        k = 2;
        ans = findKthLargest.findKthLargest(nums, k);
        Assert.assertEquals(ans, 5);

        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        ans = findKthLargest.findKthLargest(nums, k);
        Assert.assertEquals(ans, 4);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

}
