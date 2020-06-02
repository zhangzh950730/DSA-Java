package com.zzh.leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangzhihao
 * @date 2020/6/1 16:18
 */
public class KidsWithCandies_1431 {

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




