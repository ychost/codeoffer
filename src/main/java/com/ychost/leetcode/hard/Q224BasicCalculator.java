package com.ychost.leetcode.hard;

import java.util.*;

/**
 * @author ychost
 * @date 2018/8/23
 */
public class Q224BasicCalculator {
    public int calculate(String s) {
        int result = 0,sign =1,num =0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i) -'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(i+1) -'0';
                    i+=1;
                }
                result += num * sign;
            }else if(s.charAt(i) == '+'){
                sign = 1;
            }else if(s.charAt(i) == '-'){
                sign = -1;
            }else if(s.charAt(i) == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }else if(s.charAt(i) ==')'){
               result = result *stack.pop() + stack.pop() ;
            }
        }
        return result;
    }


}
