package com.zzh.geektime.程序员的数学基础课;

import java.util.ArrayList;

/**
 * 假设有一个 4 位字母密码，每位密码是 a～e 之间的小写字母。你能否编写一段代码，来暴力破解该密码？（提示：根据可重复排列的规律，生成所有可能的 4 位密码。）
 *
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/6/17 21:23
 */
public class Lesson7_2 {
    static String password = new String("bcae");

    static char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
    static int total = 0;

    public static void main(String[] args) {
        ArrayList<Character> result = new ArrayList<>(4);
        getPassWord(result);
    }

    private static void getPassWord(ArrayList<Character> result) {
        if (result.size() == 4) {
            System.out.println(result);
            System.out.println(++total);
            StringBuilder s = new StringBuilder();
            for (Character character : result) {
                s.append(character.toString());
            }
            if (s.toString().equals(password)) {
                System.out.println("找到密码 " + result);
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            ArrayList<Character> generatePassword = new ArrayList<>((ArrayList<Character>) result.clone());
            generatePassword.add(chars[i]);
            getPassWord(generatePassword);
        }
    }
}
