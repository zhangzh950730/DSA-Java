package com.zzh.数据结构_邓俊辉.chapter10_优先级队列;

public interface PriorityQueue<T> {

    void insert(T e);

    T getMax();

    T delMax();
}
