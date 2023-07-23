package com.zzh.数据结构_邓俊辉.chapter1_绪论.E_递归与迭代;

import org.apache.commons.lang3.tuple.Pair;

/**
 * 求数组中最大的两个元素
 *
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 12:32
 */
public class Max2 {
    public static void main(String[] args) {
        int[] array = {3, 5, 2, 4, 6, 8, 9, 1, 7};
        Pair<Integer, Integer> pair = max2_1(array);
        System.out.println("max first: " + pair.getKey());
        System.out.println("max second: " + pair.getValue());
        pair = max2_2(array);
        System.out.println("max first: " + pair.getKey());
        System.out.println("max second: " + pair.getValue());
        pair = max2_3(array, 0, array.length - 1);
        System.out.println("max first: " + pair.getKey());
        System.out.println("max second: " + pair.getValue());
    }

    /**
     * O(2n - 3)
     */
    private static Pair<Integer, Integer> max2_1(int[] array) {
        int maxFirstIndex = 0;
        int maxSecondIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[maxFirstIndex] < array[i]) {
                maxFirstIndex = i;
            }
        }
        for (int i = 1; i < maxFirstIndex; i++) {
            if (array[maxSecondIndex] < array[i]) {
                maxSecondIndex = i;
            }
        }
        for (int i = maxFirstIndex + 1; i < array.length; i++) {
            if (array[maxSecondIndex] < array[i]) {
                maxSecondIndex = i;
            }
        }
        return Pair.of(array[maxFirstIndex], array[maxSecondIndex]);
    }

    /**
     * 最好 : O(n - 1)
     * 最坏 : O(2n - 3)
     */
    private static Pair<Integer, Integer> max2_2(int[] array) {
        int maxFirst = array[0], maxSecond = array[1];
        if (maxFirst < maxSecond) {
            int temp = maxFirst;
            maxFirst = maxSecond;
            maxSecond = temp;
        }
        for (int i = 2; i < array.length; i++) {
            if (maxSecond < array[i]) {
                if (maxFirst < (maxSecond = array[i])) {
                    int temp = maxFirst;
                    maxFirst = maxSecond;
                    maxSecond = temp;
                }
            }
        }
        return Pair.of(maxFirst, maxSecond);
    }

    private static Pair<Integer, Integer> max2_3(int[] array, int lo, int hi) {
        int maxFirst, maxSecond;
        if (lo + 1 == hi) {
            if (array[lo] < array[hi]) {
                maxFirst = array[hi];
                maxSecond = array[lo];
            } else {
                maxFirst = array[lo];
                maxSecond = array[hi];
            }
            return Pair.of(maxFirst, maxSecond);
        }
        if (lo + 2 == hi) {
            if (array[lo] < array[lo + 1]) {
                if (array[lo + 1] < array[hi]) {
                    maxFirst = array[hi];
                    maxSecond = array[lo + 1];
                } else {
                    maxFirst = array[lo + 1];
                    maxSecond = array[hi];
                }
            } else {
                if (array[lo] < array[hi]) {
                    maxFirst = array[hi];
                    maxSecond = array[lo];
                } else {
                    maxFirst = array[lo];
                    maxSecond = array[hi];
                }
            }
            return Pair.of(maxFirst, maxSecond);
        }

        int mid = (lo + hi) / 2;
        Pair<Integer, Integer> leftPair = max2_3(array, lo, mid);
        Pair<Integer, Integer> rightPair = max2_3(array, mid + 1, hi);

        if (leftPair.getKey() < rightPair.getValue()) {
            maxFirst = rightPair.getKey();
            maxSecond = leftPair.getKey() < rightPair.getValue() ? rightPair.getValue() : leftPair.getKey();
        } else {
            maxFirst = leftPair.getKey();
            maxSecond = leftPair.getValue() < rightPair.getKey() ? rightPair.getKey() : leftPair.getValue();
        }
        return Pair.of(maxFirst, maxSecond);
    }
}
