package com.zzh.demo;

/**
 * @author ZhangZhiHao
 */
public class Vector<T> {

    private final Integer DEFAULT_CAPACITY = 4;

    /**
     * 向量中存在了多少个元素
     */
    private Integer _size;

    /**
     * 存放元素的数组
     */
    private Object[] _elem;

    public Vector() {
        _elem = new Object[DEFAULT_CAPACITY];
        _size = 0;
    }

    public void add(T t) {
        expand();
        _elem[_size++] = t;
    }

    private void expand() {
        if (_size < _elem.length) return; //尚未满员,不必扩容
        System.out.println("Vector.expand");
        int newLength = Math.max(_elem.length, DEFAULT_CAPACITY);
        Object[] oldElem = _elem;
        _elem = new Object[newLength * 2];
        for (int i = 0; i < _size; i++) {
            _elem[i] = oldElem[i];
        }
    }

    public void print() {
        System.out.println("打印开始");
        for (Object o : _elem) {
            System.out.println(" " + o);
        }
        System.out.println("打印结束");
    }

}
