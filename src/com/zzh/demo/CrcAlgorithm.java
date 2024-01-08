package com.zzh.demo;

import java.math.BigInteger;

/**
 * @version V1.0
 * @Description TODO 计算循环冗余码 需注意多项式位数与帧位数之和不得超过32位！
 */
public class CrcAlgorithm {
    public static void main(String[] args) {
        String crc = getCRC(new byte[]{0x00, 0x00, 0x03, 0x03}, new byte[]{0x00, 0x00, 0x01, 0x09});
        System.out.println("crc = " + crc);

//        String crc = getCRC("110011", "11001");
//        System.out.println("crc = " + crc);
    }

    public static String getCRC(String dataStr, String gxStr) {
        //获取二进制帧的位数
        int dataStrLen = dataStr.length();
        //获取多项式位数
        int gxStrLen = gxStr.length();
        //将二进制的字符串变为整型
        int data = toInt(dataStr);
        //将多项式的字符串变为整型
        int gx = toInt(gxStr);
        //算出原始数据补零后的总位数
        int sum = dataStrLen + gxStrLen - 1;
        //计算2的sum-1次幂
        BigInteger bi = new BigInteger("2");
        //将2的sum-1次幂转换为int型
        int flag = bi.pow(sum - 1).intValue();
        //原始帧低位补零
        data = data << (gxStrLen - 1);
        //多项式低位补零,使其与补零后的帧位数一致，以便异或
        gx = gx << (dataStrLen - 1);
        //循环dataStrLen次
        for (int i = 0; i < (dataStrLen); i++) {
            //判断补零后的帧最高位为1还是零
            if ((data & flag) != 0) {
                data = data ^ gx;
                gx = gx >> 1;
            } else {
                gx = gx >> 1;
            }
            //flag最高位的1右移
            flag = flag >> 1;
        }
        String crc = Integer.toBinaryString(data);
        //解决Java输出二进制时略去高位零的问题
        while (crc.length() < (gxStrLen - 1)) {
            crc = "0" + crc;
        }
        return crc;
    }

    private static int toInt(String dataStr) {
        return 0;
    }

    public static String getCRC(byte[] dataBytes, byte[] gxBytes) {
        //获取二进制帧的位数
        int dataStrLen = dataBytes.length;
        //获取多项式位数
        int gxStrLen = gxBytes.length;
        //将二进制的字符串变为整型
        int data = byteArrayToInt(dataBytes);
        //将多项式的字符串变为整型
        int gx = byteArrayToInt(gxBytes);
        //算出原始数据补零后的总位数
        int sum = dataStrLen + gxStrLen - 1;
        //计算2的sum-1次幂
        BigInteger bi = new BigInteger("2");
        //将2的sum-1次幂转换为int型
        int flag = bi.pow(sum - 1).intValue();
        //原始帧低位补零
        data = data << (gxStrLen - 1);
        //多项式低位补零,使其与补零后的帧位数一致，以便异或
        gx = gx << (dataStrLen - 1);
        //循环dataStrLen次
        for (int i = 0; i < (dataStrLen); i++) {
            //判断补零后的帧最高位为1还是零
            if ((data & flag) != 0) {
                data = data ^ gx;
                gx = gx >> 1;
            } else {
                gx = gx >> 1;
            }
            //flag最高位的1右移
            flag = flag >> 1;
        }
        StringBuilder crc = new StringBuilder(Integer.toBinaryString(data));
        //解决Java输出二进制时略去高位零的问题
        while (crc.length() < (gxStrLen - 1)) {
            crc.insert(0, "0");
        }
        return crc.toString();
    }

    /**
     * @param @param  bytes
     * @param @return
     * @return int
     * @throws
     * @Title: byteArrayToInt
     * @Description: byte[] 转换成 int
     */
    public static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (3 - i) * 8;
            value += (bytes[i] & 0xFF) << shift;
        }
        return value;
    }
}