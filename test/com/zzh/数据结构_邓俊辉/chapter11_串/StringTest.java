package com.zzh.数据结构_邓俊辉.chapter11_串;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTest {

    @Test
    void kmpMatch() {
        Integer[] next = String.buildNext(new char[]{'C', 'H', 'I', 'N', 'C', 'H', 'I', 'L', 'L', 'A'});
        ArrayUtils.print(next);
    }
}