package com.zzh.algs4.chapter3.section4;

import com.zzh.algs4.chapter3.section1.SequentialSearchST;

/**
 * @author ZhangZhiHao
 * @date 2021/7/26 10:40
 */
public class SeparateChainingHashST<Key, Value> {
    private int N; // 键值对总数
    private int M; // 散列表大小
    private SequentialSearchST<Key, Value>[] st; // 存放链表对象的数组

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }
}
