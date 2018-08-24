package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 50， 第一个只出现一次的字符
 * @author ychost
 * @date 2018/7/21
 */
public class Q50OnceChar {
    public int FirstNotRepeatingChar(String str) {
        if(str == null ){
            return -1;
        }
        int[] hashTable = new int[256];
        for(int i=0;i<str.length();i++){
            hashTable[str.charAt(i)] +=1;
        }
        for(int i=0;i<str.length();i++){
            if(hashTable[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}
