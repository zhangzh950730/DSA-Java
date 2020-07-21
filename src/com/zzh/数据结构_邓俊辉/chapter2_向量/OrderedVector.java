package com.zzh.数据结构_邓俊辉.chapter2_向量;

import kotlin.Pair;

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
        if (!fib.getFirst()) {
            return binSearch3(vector, e, lo, hi);
        } else {
            return fibSearch(vector, e, lo, hi, fib.getSecond());
        }
    }

    /**
     * 二分查找,左边一次,右边两次
     */
    public static int binSearch1(OrderedVector vector, Integer e, int lo, int hi) {
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

    /**
     * 斐波那契查找
     */
    public static int fibSearch(OrderedVector vector, Integer e, int lo, int hi, Fib fib) {
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

    /**
     * 二分查找,左右次数都为1
     */
    public static int binSearch2(OrderedVector vector, Integer e, int lo, int hi) {
        while (1 < hi - lo) {
            int mi = (lo + hi) >> 1;
            if (e < vector.elementData(mi)) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return vector.elementData(lo).equals(e) ? lo : -1;
    }

    /**
     * 二分查找,左右次数都为1,且返回的是不大于e的最后一个元素
     */
    public static int binSearch3(OrderedVector vector, Integer e, int lo, int hi) {
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (e < vector.elementData(mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo - 1;
    }

    public static int interpolationSearch(OrderedVector vector, Integer e, int lo, int hi) {
        hi--;
        while (lo < hi) {
            int mi = lo + (hi - lo) * (e - vector.elementData(lo)) / (vector.elementData(hi) - vector.elementData(lo));
            System.out.println("mi = " + mi);
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
        int index = OrderedVector.binSearch3(orderedVector, e, 0, orderedVector.size);
        System.out.println(e + ":index = " + index);

        array = new Integer[]{2, 3, 5, 7, 11, 13, 17};
        orderedVector = new OrderedVector(array, 0, array.length);
        System.out.println(orderedVector);
        e = 15;
        index = OrderedVector.search(orderedVector, e, 0, orderedVector.size);
        System.out.println(e + ":index = " + index);

    }
}
