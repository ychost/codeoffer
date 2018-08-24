package com.ychost.leetcode.easy;

/**
 * @author ychost
 * @date 2018/8/4
 */
public class Q191NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while((n & (n-1)) != 0){
            count +=1;
            n &= n-1;
        }

        return count;
    }
}
