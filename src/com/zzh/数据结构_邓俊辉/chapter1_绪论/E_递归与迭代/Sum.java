package com.zzh.数据结构_邓俊辉.chapter1_绪论.E_递归与迭代;

/**
 * 数组求和
 *
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/18 10:25
 */
public class Sum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int sum = sum1(array, array.length);
        System.out.println("sum = " + sum);
        sum = sum2(array, array.length);
        System.out.println("sum = " + sum);
    }

    private static int sum2(int[] array, int n) {
        return n < 1 ? 0 : sum2(array, n - 1) + array[n - 1];
    }

    private static int sum1(int array[], int n) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
}
