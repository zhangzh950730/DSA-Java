package com.zzh.数据结构_邓俊辉.chapter2_向量;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;
import kotlin.Pair;

/**
 * @author zhangzhihao
 */
public class OrderedVector extends Vector<Integer> {

    public OrderedVector(Integer[] array) {
        this(array, 0, array.length);
    }

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

    public int search(Integer e, int lo, int hi) {
        Pair<Boolean, Fib> fib = fib(hi - lo);
        if (!fib.getFirst()) {
            return binSearch3(e, lo, hi);
        } else {
            return fibSearch(e, lo, hi, fib.getSecond());
        }
    }

    /**
     * 二分查找,左边一次,右边两次
     */
    public int binSearch1(Integer e, int lo, int hi) {
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (e < elementData(mi)) {
                hi = mi;
            } else if (elementData(mi) < e) {
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
    public int fibSearch(Integer e, int lo, int hi, Fib fib) {
        while (lo < hi) {
            while (hi - lo < fib.get()) {
                fib = fib.prev;
            }
            int mi = lo + fib.get() - 1;
            if (e < elementData(mi)) {
                hi = mi;
            } else if (elementData(mi) < e) {
                lo = mi + 1;
            } else {
                return mi;
            }
        }
        return -1;
    }

    private Pair<Boolean, Fib> fib(int size) {
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
    public int binSearch2(Integer e, int lo, int hi) {
        while (1 < hi - lo) {
            int mi = (lo + hi) >> 1;
            if (e < elementData(mi)) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return elements[lo] == (e) ? lo : -1;
    }

    /**
     * 二分查找,左右次数都为1,且返回的是不大于e的最后一个元素
     */
    public int binSearch3(Integer e, int lo, int hi) {
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (e < elementData(mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo - 1;
    }

    /**
     * 插值查找
     */
    public int interpolationSearch(Integer e, int lo, int hi) {
        hi--;
        while (lo < hi) {
            int mi = lo + (hi - lo) * (e - elementData(lo)) / (elementData(hi) - elementData(lo));
            if (e < elementData(mi)) {
                hi = mi;
            } else if (elementData(mi) < e) {
                lo = mi + 1;
            } else {
                return mi;
            }
        }
        return -1;
    }

    /**
     * 提前终止版
     */
    public void bubbleSort1(int lo, int hi) {
        for (boolean sorted = false; sorted = !sorted; hi--) {
            for (int i = lo; i < hi - 1; i++) {
                System.out.print(" i = " + i);
                if (elementData(i + 1) < elementData(i)) {
                    ArrayUtils.swap(elements, i + 1, i);
                    sorted = false;
                }
            }
            System.out.println();
        }
    }

    /**
     * 跳跃版
     */
    public void bubbleSort2(int lo, int hi) {
        for (int last = --hi; lo < hi; hi = last) {
            for (int i = last = lo; i < hi; i++) {
                System.out.print(" i = " + i);
                if (elementData(i + 1) < elementData(i)) {
                    ArrayUtils.swap(elements, i + 1, i);
                    last = i;
                }
            }
            System.out.println();
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort(int lo, int hi) {
        if (hi - lo < 2) {
            return;
        }
        int mi = (lo + hi) >> 1;
        mergeSort(lo, mi);
        mergeSort(mi, hi);
//        merge1(lo, mi, hi);
        merge2(lo, mi, hi);
    }

    private void merge1(int lo, int mi, int hi) {
        System.out.print("OrderedVector.merge1");
        System.out.print(" lo = " + lo);
        System.out.print(" mi = " + mi);
        System.out.print(" hi = " + hi);
        System.out.println();

        int lb = mi - lo;
        int lc = hi;
        Integer[] temporary = new Integer[lb];
        for (int i = 0; i < lb; i++) {
            temporary[i] = elementData(i + lo);
        }
        for (int i = lo, j = 0, k = mi; j < lb || k < lc; ) {
            if (j < lb && (lc <= k || temporary[j] < elementData(k))) {
                elements[i++] = temporary[j++];
            }
            if (k < lc && (lb <= j || elementData(k) < temporary[j])) {
                elements[i++] = elements[k++];
            }
        }
        ArrayUtils.print(elements);
    }

    private void merge2(int lo, int mi, int hi) {
        System.out.print("OrderedVector.merge1");
        System.out.print(" lo = " + lo);
        System.out.print(" mi = " + mi);
        System.out.print(" hi = " + hi);
        System.out.println();

        int lb = mi - lo;
        Integer[] temporary = new Integer[lb];
        for (int i = 0; i < lb; i++) {
            temporary[i] = elementData(i + lo);
        }
        for (int i = lo, j = 0, k = mi; j < lb; ) {
            elements[i++] = (hi <= k || temporary[j] <= elementData(k)) ? temporary[j++] : elements[k++];
        }
        ArrayUtils.print(elements);
    }

    public static void main(String[] args) {
        Integer[] array = {3, 3, 3, 3, 5, 5, 5, 5, 5, 8, 8, 8, 13, 13, 13, 13};
        OrderedVector orderedVector = new OrderedVector(array, 0, array.length);
        System.out.println(orderedVector);

        int uniquify = orderedVector.uniquify();
        System.out.println(orderedVector);
        System.out.println("uniquify = " + uniquify);

        int e = 3;
        int index = orderedVector.binSearch3(e, 0, orderedVector.size);
        System.out.println(e + ":index = " + index);

        array = new Integer[]{2, 3, 5, 7, 11, 13, 17};
        orderedVector = new OrderedVector(array, 0, array.length);
        System.out.println(orderedVector);
        e = 15;
        index = orderedVector.search(e, 0, orderedVector.size);
        System.out.println(e + ":index = " + index);

        array = new Integer[]{5, 10, 12, 14, 26, 31, 38, 39, 42, 46, 49, 51, 54, 59, 72, 79, 82, 86, 92};
        orderedVector = new OrderedVector(array, 0, array.length);
        System.out.println(orderedVector);
        e = 50;
        index = orderedVector.interpolationSearch(e, 0, array.length);
        System.out.println(e + ":index = " + index);

        array = new Integer[]{9, 3, 0, 1, 2, 4, 5, 6, 7, 8};
        orderedVector = new OrderedVector(array, 0, array.length);
        orderedVector.bubbleSort1(0, array.length);
        System.out.println("bubbleSort1 = " + orderedVector);

        array = new Integer[]{9, 3, 0, 1, 2, 4, 5, 6, 7, 8};
        orderedVector = new OrderedVector(array);
        orderedVector.bubbleSort2(0, array.length);
        System.out.println("bubbleSort2 = " + orderedVector);

        array = new Integer[]{9, 3, 0, 1, 2, 4, 5, 6, 7, 8};
        orderedVector = new OrderedVector(array);
        System.out.println("mergeSortBefor = " + orderedVector);
        orderedVector.mergeSort(0, array.length);
        System.out.println("mergeSortAfter = " + orderedVector);
    }
}
