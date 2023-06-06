package com.zzh.数据结构_邓俊辉.chapter11_串;

import com.zzh.util.ArrayUtils;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void kmpMatch() {
        Integer[] next = String.buildNext(new char[]{'C', 'H', 'I', 'N', 'C', 'H', 'I', 'L', 'L', 'A'});
        ArrayUtils.print(next);
    }
}