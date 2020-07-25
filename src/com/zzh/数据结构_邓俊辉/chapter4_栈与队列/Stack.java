package com.zzh.数据结构_邓俊辉.chapter4_栈与队列;

import com.zzh.geektime.数据结构与算法之美.array.ArrayUtils;
import com.zzh.数据结构_邓俊辉.chapter2_向量.Vector;

/**
 * @author <a href="zhangzh950730@gmail.com" >ZhangZhiHao</a>
 * @since 2020/7/24 22:06
 */
public class Stack<T> extends Vector<T> {

    public Stack() {
        super();
    }

    public void push(T e) {
        insert(size, e);
    }

    public T pop() {
        return remove(size - 1);
    }

    public T top() {
        return elementData(size - 1);
    }

    /**
     * 栈应用1 进制转换
     * 十进制转换成指定进制
     *
     * @param n 十进制数字
     * @param base 要转换的进制
     */
    public static Character[] convert(int n, int base) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        Stack<Character> stack = new Stack<>();
        while (0 < n) {
            stack.push(digit[n % base]);
            n /= base;
        }
        Character[] result = new Character[stack.size];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static boolean paren(Character[] characters, int lo, int hi) {
        Stack<Character> stack = new Stack<>();
        for (int i = lo; i < hi; i++) {
            Character character = characters[i];
            if (isLeftParen(character)) {
                stack.push(character);
            } else if (isRightParen(character)) {
                if (stack.elements.length > 0) {
                    if (!isMatches(stack.pop(), character)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.elements.length == 0;
    }

    private static boolean isMatches(Character left, Character right) {
        switch (left) {
            case '(':
                return right.equals(')');
            case '[':
                return right.equals(']');
            case '{':
                return right.equals('}');
            default:
                return false;
        }
    }

    private static boolean isRightParen(Character character) {
        return character.equals(')') || character.equals(']') || character.equals('}');
    }

    private static boolean isLeftParen(Character character) {
        return character.equals('(') || character.equals('[') || character.equals('{');
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Integer pop = stack.pop();
        System.out.println("pop = " + pop);

        Integer top = stack.top();
        System.out.println("top = " + top);

        Character[] convert = convert(175, 16);
        ArrayUtils.print(convert);

        Character[] characters = {'[', '{', '}', '(', ')', '(', '9', ')', ']'};
        boolean paren = Stack.paren(characters, 0, characters.length);
        System.out.println("paren = " + paren);
    }
}
