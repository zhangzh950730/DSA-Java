package com.zzh.geektime.数据结构与算法之美.stack;

/**
 * @author zhangzhihao
 * @date 2020/6/19 14:56
 */
public class ArrayStack {

    /**
     * 数组
     */
    private String[] items;

    /**
     * 栈中元素个数
     */
    private int count;

    /**
     * 栈的大小
     */
    private int n;

    public ArrayStack(int n) {
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public boolean push(String item) {
        if (count == n) {
            return false;
        }
        items[count++] = item;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        return items[--count];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("1");
        stack.push("3");
        System.out.println(stack.pop());
        stack.push("2");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
