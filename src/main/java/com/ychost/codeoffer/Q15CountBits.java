package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 15，二进制中 1 的个数
 * @author ychost
 * @date 2018/7/8
 */
public class Q15CountBits {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            if((n&1)==1){
                count +=1;
            }
            n >>>=1;
        }
        return count;
    }

    public int NumberOf1_2(int n){
        int count =0;
        while(n !=0){
            count ++;
            n &=(n-1);
        }
        return count;
    }
}
