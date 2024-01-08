package com.zzh.demo;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class CheckSumDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        byte[] bytes;
        int checkSum;

//        bytes = new byte[]{0x66, 0x39, 0x32, 0x30, 0x38, 0x32, 0x39, 0x33, 0x34, 0x01};
//        checkSum = checkSum(bytes);
//        System.out.println("0x0b=11 ; checkSum = " + (checkSum));
//        System.out.println("0x0b=11 ; checkSum & 0xff = " + (checkSum & 0xff));
//        System.out.println();
//
//        bytes = new byte[]{0x65, 0x01};
//        checkSum = checkSum(bytes);
//        System.out.println("0x66=102 ; checkSum = " + (checkSum));
//        System.out.println("0x66=102 ; checkSum & 0xff = " + (checkSum & 0xff));
//        System.out.println();
//
//
//        bytes = new byte[]{0x69, 0x10, 0x6c, 0x73, 0x6f};
//        checkSum = checkSum(bytes);
//        System.out.println("0xc7=199 ; checkSum = " + (checkSum));
//        System.out.println("0xc7=199 ; checkSum & 0xff = " + (checkSum & 0xff));
//        System.out.println();

        bytes = new byte[]{0x00, 0x00, 0x00, 0x00, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x30, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0x08, 0x07, 0x00, 0x02, 0x0a, 0x05, 0x00, 0x00, 0x00, 0x00, 0x20, 0x23, 0x05, 0x09, 0x10, 0x33, 0x34, (byte) 0xff, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xbd, (byte) 0xe5, (byte) 0xec, 0x43, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
        checkSum = checkSum((short) 106, bytes);
        System.out.println("0x31 49 ?= checkSum: " + checkSum);
        System.out.println("0x31 49 ?= checkSum: " + (checkSum & 0xff));
    }

    private static int checkSum(Short command, byte[] bytes) {
        int length = bytes.length + 2;
        byte[] newBytes = Arrays.copyOf(bytes, length);
        newBytes[length - 2] = (byte) (command & 0xff00);
        newBytes[length - 1] = (byte) (command & 0xff);

        int sum = 0;
        for (byte aByte : newBytes) {
            sum += aByte;
        }
        return sum;
    }

}

