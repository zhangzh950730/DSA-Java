package com.zzh.数据结构_邓俊辉.chapter2_向量;

import javafx.util.Pair;

/**
 * @author zhangzhihao
 */
public class OrderedVector extends Vector<Integer> {

    public OrderedVector(Integer[] array, int lo, int hi) {
        super(array, lo, hi);
    }

    public int uniquify() {
        int i = 0, j = 0;
        while (++j < size) {
            if (elements[i] != elements[j]) {
                elements[++i] = elements[j];
            }
        }
        int old = size;
        size = i + 1;
        shrink();
        return old - size;
    }

    public static int search(OrderedVector vector, Integer e, int lo, int hi) {
        Pair<Boolean, Fib> fib = fib(hi - lo);
        if (!fib.getKey()) {
            return binSearch(vector, e, lo, hi);
        } else {
            return fibSearch(vector, e, lo, hi, fib.getValue());
        }
    }

    private static Pair<Boolean, Fib> fib(int size) {
        size++;
        Fib prev = new Fib(1, 1, new Fib(0, 0, null));
        for (int index = 2, i = 0, j = 1; j < size; index++) {
            j = j + i;
            i = j - i;
            prev = new Fib(index, j, prev);
        }
        return new Pair<>(prev.get() == size, prev);
    }

    private static int fibSearch(OrderedVector vector, Integer e, int lo, int hi, Fib fib) {
        while (lo < hi) {
            while (hi - lo < fib.get()) {
                fib = fib.prev;
            }
            int mi = lo + fib.get() - 1;
            if (e < vector.elementData(mi)) {
                hi = mi;
            } else if (vector.elementData(mi) < e) {
                lo = mi + 1;
            } else {
                return mi;
            }
        }
        return -1;
    }

    private static int binSearch(OrderedVector vector, Integer e, int lo, int hi) {
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (e < vector.elementData(mi)) {
                hi = mi;
            } else if (vector.elementData(mi) < e) {
                lo = mi + 1;
            } else {
                return mi;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] array = {3, 3, 3, 3, 5, 5, 5, 5, 5, 8, 8, 8, 13, 13, 13, 13};
        OrderedVector orderedVector = new OrderedVector(array, 0, array.length);
        System.out.println(orderedVector);

        int uniquify = orderedVector.uniquify();
        System.out.println(orderedVector);
        System.out.println("uniquify = " + uniquify);

        int e = 3;
        int index = OrderedVector.binSearch(orderedVector, e, 0, orderedVector.size);
        System.out.println(e + ":index = " + index);

        array = new Integer[]{2, 3, 5, 7, 11, 13, 17};
        orderedVector = new OrderedVector(array, 0, array.length);
        e = 11;
        index = OrderedVector.search(orderedVector, e, 0, orderedVector.size);
        System.out.println(e + ":index = " + index);

    }
}
