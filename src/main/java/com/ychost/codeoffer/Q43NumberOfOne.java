package com.ychost.codeoffer;

/**
 * 剑指offer 面试题 43,1~n 整数中 1 出现的次数
 * @author ychost
 * @date 2018/7/15
 */
public class Q43NumberOfOne {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n < 0){
            return 0;
        }
        String str = String.valueOf(n);
        int first = str.charAt(0) - '0';
        if(str.length() == 1){
            if(first == 0){
                return 0;
            }else if(first > 0){
                return 1;
            }
        }
        int numOfFirst = 0;
        if(first > 1){
           numOfFirst = (int)Math.pow(10,str.length() -1);
        }else if(first == 1){
           numOfFirst = Integer.valueOf(str.substring(1))+1;
        }
        first = str.charAt(1) - '0';
        int numOfOther = first *(str.length() -1) + (int)Math.pow(10,str.length() -2);
        int numOfRec = NumberOf1Between1AndN_Solution(Integer.valueOf(str.substring(1)));
        return numOfFirst + numOfOther + numOfRec;
    }
    public int NumberOf1Between1AndN_Solution2(int num) {
        if(num <= 0) {
            return 0;
        }
        int count = 0;
        int current = 0;
        int base = 1;
        int remain = 0;
        while(num > 0){
           current = num %  10;
           num = num / 10;
           if(current == 0){
               count += num * base;
           }else if(current == 1){
                count += num * base + (remain + 1);
           }else{
               count += (num +1) * base;
           }
           remain += current * base;
           base *= 10;
        }

        return count;
    }
}
