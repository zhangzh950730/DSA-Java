package com.zzh.数据结构_邓俊辉.chapter1_绪论.D_算法分析;

import com.zzh.util.ArrayUtils;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void bubbleSort() {
        Integer[] array = {4, 5, 2, 7, 8, 1, 3, 6};
        BubbleSort.bubbleSort(array);
        ArrayUtils.print(array);
    }
}