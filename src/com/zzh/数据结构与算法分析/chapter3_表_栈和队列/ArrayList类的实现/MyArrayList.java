package com.zzh.数据结构与算法分析.chapter3_表_栈和队列.ArrayList类的实现;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author zhangzhihao
 * @date 2020/7/19 9:32
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int index) {
        if (index < 0 || index > theSize) {
            throw new IndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public AnyType set(int index, AnyType newVal) {
        if (index < 0 || index > theSize) {
            throw new IndexOutOfBoundsException();
        }
        var old = theItems[index];
        theItems[index] = newVal;
        return old;
    }

    public boolean add(AnyType x) {
        return add(size(), x);
    }

    public boolean add(int index, AnyType x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > index; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[index] = x;
        theSize++;
        return true;
    }

    public void remove(int index) {
        for (int i = index; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }
        theItems[theSize--] = null;
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        var old = this.theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < theSize; i++) {
            theItems[i] = old[i];
        }
    }


    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    public static void main(String[] args) {
        var list = new MyArrayList<Integer>();
        list.add(4);
        list.add(7);
        list.add(8);
        list.add(6);
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            var val = iterator.next();
            if (val == 7) {
                iterator.remove();
            }
            System.out.println(val);
        }
    }
}
