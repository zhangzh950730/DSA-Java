package com.zzh.algs4.chapter3.section4;

import javax.swing.*;

/**
 * @author ZhangZhiHao
 * @date 2021/7/26 10:58
 */
public class LinearProbingHashST<Key, Value> {
    private int N;// 键值对总数
    private int M = 16;// 线性探测表的大小
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int cap) {
        keys = (Key[]) new Object[cap];
        vals = (Value[]) new Object[cap];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value value) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = value;
                return;
            }
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }

    }

    private boolean contains(Key key) {
        for (Key cacheKey : keys) {
            if (cacheKey.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
