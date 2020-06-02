package com.zzh.geektime.chapter5_array;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @author zhangzhihao
 * @date 2020/6/1 15:24
 */
public class Array {
    /**
     * 定义整型数据data保存数据
     */
    private int[] data;

    /**
     * 定义数组长度
     */
    private int n;

    /**
     * 定义中实际个数
     */
    private int count;


    /**
     * 构造方法，定义数组大小
     */
    public Array(int capacity) {
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    /**
     * 根据索引，找到数据中的元素并返回
     */
    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    /**
     * 插入元素:头部插入，尾部插入
     */
    public boolean insert(int index, int value) {
        if (n == count) {
            System.out.println("数组已满");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("index不合法");
            return false;
        }

        // 批量后移
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        // 插入新数据
        data[index] = value;
        count++;
        return true;
    }

    /**
     * 根据索引，删除数组中元素
     */
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            System.out.println("index不合法");
            return false;
        }

        for (int i = index; i < count; i++) {
            data[index] = data[index + 1];
        }

        count--;
        return true;
    }

    public void printAll() {
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }
}
