package com.zzh.leetcode._701_800;

import org.junit.Assert;

import java.util.Stack;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _735_asteroidCollision {

    public static void main(String[] args) {
        _735_asteroidCollision asteroidCollision = new _735_asteroidCollision();
        int[] asteroids, ans;

        asteroids = new int[]{5, 10, -5};
        ans = asteroidCollision.asteroidCollision(asteroids);
        Assert.assertArrayEquals(new int[]{5, 10}, ans);

        asteroids = new int[]{8, -8};
        ans = asteroidCollision.asteroidCollision(asteroids);
        Assert.assertArrayEquals(new int[0], ans);

        asteroids = new int[]{10, 2, -5};
        ans = asteroidCollision.asteroidCollision(asteroids);
        Assert.assertArrayEquals(new int[]{10}, ans);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int aster : asteroids) {
            boolean alive = true;
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -aster;
                if (stack.peek() <= -aster) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
