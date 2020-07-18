package com.zzh.数据结构_邓俊辉.chapter1_绪论.D_算法分析;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

/**
 * 冒泡排序
 *
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 9:39
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {4, 5, 2, 7, 8, 1, 3, 6};
        bubbleSort(array);
        ArrayUtils.print(array);
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (boolean sorted = false; sorted = !sorted; n--) {
            for (int i = 1; i < n; i++) {
                if (array[i] < array[i - 1]) {
                    ArrayUtils.swap(array, i, i - 1);
                }
                sorted = false;
            }
        }
    }
}
