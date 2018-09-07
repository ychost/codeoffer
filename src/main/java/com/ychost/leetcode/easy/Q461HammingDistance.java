package com.ychost.leetcode.easy;

/**
 * @author ychost
 * @date 2018/9/7
 */
public class Q461HammingDistance {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int cnt = 0;
        while(z !=0){
           cnt +=1;
           z &=z-1;
        }
        return cnt;
    }
}
