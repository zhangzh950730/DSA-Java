package com.zzh.数据结构_邓俊辉.chapter2_向量;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/19 22:38
 */
public class Fib {
    private int index;
    private int data;
    public Fib prev;

    public Fib(int index, int data) {
        this.index = index;
        this.data = data;
    }

    public Fib(int index, int data, Fib prev) {
        this.index = index;
        this.data = data;
        this.prev = prev;
    }

    public int get() {
        return data;
    }

    @Override
    public String toString() {
        return "Fib{" +
                "index=" + index +
                ", data=" + data +
                ", prev=" + prev +
                '}';
    }
}
