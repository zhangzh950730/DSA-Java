package com.zzh.数据结构_邓俊辉.chapter2_向量;


import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 23:24
 */
public class Vector<T> implements Comparator<T> {
    protected T[] elements;
    protected int size;
    protected static final int DEFAULT_CAPACITY = 3;

    public Vector() {
        this(DEFAULT_CAPACITY);
    }

    public Vector(int capacity) {
        elements = (T[]) new Object[capacity];
    }

    public Vector(T[] array, int lo, int hi) {
        this(array.length);
        while (lo < hi) {
            elements[size++] = array[lo++];
        }
    }

    public boolean insert(int index, T e) {
        expand();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;
        return true;
    }

    public T remove(int index) {
        T e = elements[index];
        remove(index, index + 1);
        return e;
    }

    public int find(T e, int lo, int hi) {
        while (lo < hi-- && e != elements[hi]) {
        }
        return hi;
    }

    public int remove(int lo, int hi) {
        if (hi == lo) {
            return 0;
        }
        while (hi < size) {
            elements[lo++] = elements[hi++];
        }
        size = lo;
        shrink();
        return hi - lo;
    }

    public int deduplicate() {
        int oldSize = this.size;
        int index = 1;
        while (index < size) {
            if (find(elements[index], 0, index) < 0) {
                index++;
            } else {
                remove(index);
            }
        }
        return oldSize - size;
    }

    public int disordered() {
        int n = 0;
        for (int i = 1; i < size; i++) {
            if (compare(elements[i - 1], elements[i]) > 0) {
                n++;
            }
        }
        return n;
    }

    public void traverse(Function<T, T> function) {
        for (int i = 0; i < size; i++) {
            elements[i] = function.apply(elements[i]);
        }
    }

    protected void shrink() {
        T[] old = this.elements;
        elements = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            elements[i] = old[i];
        }
    }

    protected void expand() {
        if (elements.length < size) {
            return;
        }
        T[] old = elements;
        elements = (T[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            elements[i] = old[i];
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

    @Override
    public int compare(T e1, T e2) {
        if (e1 instanceof Integer && e2 instanceof Integer) {
            Integer n1 = (Integer) e1;
            Integer n2 = (Integer) e2;
            return n1.compareTo(n2);
        }
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        System.out.println(vector);

        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        vector = new Vector<>(array, 0, array.length);
        System.out.println(vector);

        vector.traverse(integer -> ++integer);
        System.out.println(vector);

        vector.remove(3);
        System.out.println(vector);
    }
}
