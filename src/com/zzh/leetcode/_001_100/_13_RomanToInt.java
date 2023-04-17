package com.zzh.leetcode._001_100;

import org.junit.Assert;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _13_RomanToInt {

    public static void main(String[] args) {
        _13_RomanToInt romanToInt_13 = new _13_RomanToInt();
        int i = romanToInt_13.romanToInt("IV");
        Assert.assertEquals(i, 4);

        i = romanToInt_13.romanToInt("IX");
        Assert.assertEquals(i, 9);

        i = romanToInt_13.romanToInt("LVIII");
        Assert.assertEquals(i, 58);

        i = romanToInt_13.romanToInt("MCMXCIV");
        Assert.assertEquals(i, 1994);

    }

    public int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        char[] chars = s.toCharArray();
        int result = 0;
        for (char aChar : chars) {
            result += get(aChar);
        }
        return result;
    }

    private int get(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default: return 0;
        }
    }

}
