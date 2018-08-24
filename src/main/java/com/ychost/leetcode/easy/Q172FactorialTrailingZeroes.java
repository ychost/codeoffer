package com.ychost.leetcode.easy;

/**
 * @author ychost
 * @date 2018/8/4
 */
public class Q172FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n>=5){
            count += n/5;
            n/=5;
        }
        return count;
    }
}
