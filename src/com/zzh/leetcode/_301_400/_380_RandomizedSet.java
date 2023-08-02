package com.zzh.leetcode._301_400;

import java.util.*;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _380_RandomizedSet {

    public static void main(String[] args) {

    }

    static class RandomizedSet {
        private final List<Integer> nums;
        private final Map<Integer, Integer> indices;
        private final Random random;

        public RandomizedSet() {
            nums = new ArrayList<>();
            indices = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) return false;
            indices.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) return false;
            Integer index = indices.get(val);
            Integer last = nums.get(nums.size() - 1);

            // 将当前数组最后一个元素挪到要删除元素的位置
            nums.set(index, last);
            indices.put(last, index);

            // 删除元素
            nums.remove(nums.size() - 1);
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
