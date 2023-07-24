package com.zzh.leetcode._701_800;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:374752943@qq.com">ZhiHao Zhang</a>
 */
public class _771_numJewelsInStones {

    public static void main(String[] args) {
        _771_numJewelsInStones numJewelsInStones = new _771_numJewelsInStones();
        String jewels, stones;
        int ans;

        jewels = "aA";
        stones = "aAAbbbb";
        ans = numJewelsInStones.numJewelsInStones(jewels, stones);
        Assert.assertEquals(ans, 3);

        jewels = "z";
        stones = "ZZ";
        ans = numJewelsInStones.numJewelsInStones(jewels, stones);
        Assert.assertEquals(ans, 0);
    }

    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set<Character> set = new HashSet<>(jewels.length());
        for (int i = 0; i < jewels.length(); i++) {
            char c = jewels.charAt(i);
            set.add(c);
        }
        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if (set.contains(c)) ans++;
        }
        return ans;
    }
}
