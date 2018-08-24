package com.ychost.leetcode.easy;

/**
 * @author ychost
 * @date 2018/8/4
 */
public class Q326PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        while(n % 3 == 0){
            n/=3;
        }
        return n == 0;
    }
}
