package com.zzh.demo;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZhangZhiHao
 */
public class RetainAllDemo {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println(array.length);

        List<String> a = Stream.of("a", "b", "c").collect(Collectors.toList());
        List<String> b = Stream.of("e", "d", "c").collect(Collectors.toList());
        a.retainAll(b);
        for (String s : b) {
            System.out.println("s = " + s);
        }
        System.out.println("==");
        for (String s : a) {
            System.out.println("s = " + s);
        }
    }
}
