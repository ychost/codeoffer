package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 16，数值的整数次芳
 * @author ychost
 * @date 2018/7/8
 */
public class Q16XPower {
    public double Power(double base, int exponent) {
        if(base == 0.0 && exponent < 0){
            return 0;
        }
        int absExp = Math.abs(exponent);
        if(absExp == 0){
            return 1;
        }
        double result = base;
        while(absExp > 1){
            result *=result;
            absExp >>=1;
        }
        if((absExp & 1) == 1){
            result *= base;
        }
        if(exponent < 0){
            result = 1/result;
        }
        return  result;
    }
}
