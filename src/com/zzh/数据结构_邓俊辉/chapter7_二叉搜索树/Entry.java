package com.zzh.数据结构_邓俊辉.chapter7_二叉搜索树;

/**
 * @author zhangzhihao
 * @date 2020/7/28 19:18
 */
public abstract class Entry<K, V> {
    K key;
    V value;

    public Entry() {
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
