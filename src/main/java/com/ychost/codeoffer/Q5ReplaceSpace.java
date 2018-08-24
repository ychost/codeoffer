package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 5，替换空格
 */
public class Q5ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        int spaceCount = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                spaceCount +=1;
            }
        }
        if(spaceCount == 0){
            return str.toString();
        }
        int oldLength = str.length();
        int newLength = spaceCount * 2 + str.length();
        for(int i=str.length();i<newLength;i++){
            str.append('x');
        }
        int j = newLength -1;
        for(int i=oldLength -1;i>=0;i--){
            if(str.charAt(i) == ' '){
                str.setCharAt(j--,'0');
                str.setCharAt(j--,'2');
                str.setCharAt(j--,'%');
            }else{
                str.setCharAt(j--,str.charAt(i));
            }
        }
        return str.toString();
    }
}
