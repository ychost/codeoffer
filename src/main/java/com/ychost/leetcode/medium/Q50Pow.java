package com.ychost.leetcode.medium;

public class Q50Pow {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0){
            x = 1/x;
            N=-N;
        }
         return pow(x,N);
    }

    public double pow(double base,long exp){
        if(exp <= 0){
            return 1;
        }
        double result = pow(base,exp>>1);
        result *= result;
        if((exp & 0x01) == 1){
            result *= base;
        }
        return result;
    }
}
