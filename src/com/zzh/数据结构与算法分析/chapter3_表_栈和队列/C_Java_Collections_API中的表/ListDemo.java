package com.zzh.数据结构与算法分析.chapter3_表_栈和队列.C_Java_Collections_API中的表;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangzhihao
 * @date 2020/7/17 16:36
 */
public class ListDemo {

    private static void makeList1(List<Integer> list, int n) {
        var start = System.currentTimeMillis();
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    private static void makeList2(List<Integer> list, int n) {
        var start = System.currentTimeMillis();
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(0, i);
        }
    }

    private static int sum(List<Integer> list) {
        int total = 0;
        for (Integer integer : list) {
            total += integer;
        }
        return total;
    }

    /**
     * LinkedList : get()和remove()操作都将花费O(n)时间 总计 O(2n²)
     * 且在循环中调用remove()方法是非法的
     */
    @Deprecated
    private static void removeEvensVer1(List<Integer> list) {
        for (int i = 0; i < list.size(); ) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * LinkedList : 虽然用迭代器可以节省查找的花费,但remove()方法仍需花费O(n) 总计O(n²)
     * 且在循环中调用remove()方法是非法的
     */
    @Deprecated
    private static void removeEvensVer2(List<Integer> list) {
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                list.remove(integer);
            }
        }
    }

    /**
     * LinkedList : 使用迭代器的remove()方法,只需花费O(1)的时间 总计O(n)
     * ArrayList : 即使迭代器删除只需O(1),但是删除后的数组移动还是需要O(n) 总计O(n²)
     */
    private static void removeEvensVer3(List<Integer> list) {
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }


    public static void main(String[] args) {
        // 数据规模
        var n = 100000;
        var linkedList = new LinkedList<Integer>();
        var arrayList = new ArrayList<Integer>();

        System.out.println("makeList1 末端添加");

        var start = System.currentTimeMillis();
        makeList1(linkedList, n);
        System.out.println("LinkedList timeMillis : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        makeList1(arrayList, n);
        System.out.println("ArrayList timeMillis : " + (System.currentTimeMillis() - start));


        System.out.println("makeList2 前端添加");

        start = System.currentTimeMillis();
        makeList2(linkedList, n);
        System.out.println("LinkedList timeMillis : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        makeList2(arrayList, n);
        System.out.println("ArrayList timeMillis : " + (System.currentTimeMillis() - start));

        System.out.println("List sum");

        makeList1(linkedList, n);
        start = System.currentTimeMillis();
        sum(linkedList);
        System.out.println("LinkedList timeMillis : " + (System.currentTimeMillis() - start));

        makeList1(arrayList, n);
        start = System.currentTimeMillis();
        sum(arrayList);
        System.out.println("ArrayList timeMillis : " + (System.currentTimeMillis() - start));

        System.out.println("List remove");

        start = System.currentTimeMillis();
        removeEvensVer3(linkedList);
        System.out.println("LinkedList timeMillis : " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        removeEvensVer3(arrayList);
        System.out.println("ArrayList timeMillis : " + (System.currentTimeMillis() - start));
    }
}
