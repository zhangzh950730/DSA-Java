package com.zzh.数据结构_邓俊辉.chapter1_绪论.XC_动态规划;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LCSTest {

    @Test
    void main() {
        String a ="didactic";
        String b ="advant";
        Integer lsc = LCS.lcs(a, b);
        System.out.println(lsc);
    }
}