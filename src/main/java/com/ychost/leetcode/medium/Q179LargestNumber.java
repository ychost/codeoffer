package com.ychost.leetcode.medium;

import java.util.Arrays;

public class Q179LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array,(a,b)->{
           String s1 = String.valueOf(a) + String.valueOf(b);
           String s2 = String.valueOf(b) + String.valueOf(a);
           return s1.compareTo(s2);
       });
        if(String.valueOf(array[0]).charAt(0) == '0'){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (Integer v : array) {
           res.append(v);
        }
        return res.toString();
    }
}
