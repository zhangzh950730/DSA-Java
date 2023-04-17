package com.zzh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * @author zhangzhihao
 * @date 2020/6/1 16:18
 */
public class _1431_KidsWithCandies {
    /**
     * 枚举
     * 首先记录持有糖果最多的孩子,然后遍历所有孩子并分配糖果和判断
     */
    static class Solution {
        public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = candies[0];
            for (int i = 1; i < candies.length; i++) {
                max = Math.max(candies[i], max);
            }

            List<Boolean> result = new ArrayList<>(candies.length);
            for (int i = 0; i < candies.length; i++) {
                result.add(candies[i] + extraCandies >= max);
            }
            return result;
        }

        public static void main(String[] args) {
            List<Boolean> result = kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
            System.out.println(result);

            result = kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1);
            System.out.println(result);

            result = kidsWithCandies(new int[]{12, 1, 12}, 10);
            System.out.println(result);
        }
    }
}




