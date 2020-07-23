package com.zzh.geektime.数据结构与算法之美.array;

import java.util.Objects;

/**
 * @author zhangzhihao
 */
public class ArrayUtils {

    public static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void print(Object[] array) {
        System.out.print("{");
        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 4, 3};
        swap(nums, 2, 3);
        print(nums);
    }

}
