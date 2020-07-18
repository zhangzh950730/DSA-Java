package com.zzh.数据结构_邓俊辉.chapter2_向量.A_接口与实现;


/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 23:24
 */
public class Vector<T> {
    private T[] elements;
    private int size;
    private final int DEFAULT_CAPACITY = 3;

    public Vector() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public Vector(T[] array, int lo, int hi) {
        elements = (T[]) new Object[array.length * 2];
        while (lo < hi) {
            elements[size++] = array[lo++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            sb.append(", ").append(elements[i]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        System.out.println(vector);

        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        vector = new Vector<>(array, 0, array.length);
        System.out.println(vector);
    }
}
