package com.zzh.数据结构_邓俊辉.chapter1_绪论.E_递归与迭代;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;

/**
 * 数组元素的颠倒
 *
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 10:47
 */
public class Reverse {

    public static void main(String[] args) {
        Integer[] array = {7, 6, 5, 4, 3, 2, 1};
        reverse1(array, 0, array.length - 1);
        ArrayUtils.print(array);
        array = new Integer[]{8, 7, 6, 5, 4, 3, 2, 1};
        reverse2(array, 0, array.length - 1);
        ArrayUtils.print(array);
    }

    private static void reverse2(Integer[] array, int lo, int hi) {
        while (lo < hi) {
            ArrayUtils.swap(array, lo++, hi--);
        }
    }

    private static void reverse1(Integer[] array, int lo, int hi) {
        if (lo < hi) {
            ArrayUtils.swap(array, lo++, hi--);
            reverse1(array, lo, hi);
        }
    }
}
