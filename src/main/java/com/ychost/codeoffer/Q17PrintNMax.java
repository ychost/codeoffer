package com.ychost.codeoffer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 剑指Offer 面试题 17，打印从 1 到最大的 n 位数
 * @author ychost
 * @date 2018/7/8
 */
public class Q17PrintNMax {
   void print(int n){
      char[] numbers = new char[n];
      Arrays.fill(numbers,'0');
      while(inc(numbers)){
         print(numbers);
      }
   }

   void print2(int n){
      char[] numbers = new char[n];
      Arrays.fill(numbers,'0');
      printRec(numbers,0);
   }

   void printRec(char[] numbers,int index){
      if(index == numbers.length){
          print(numbers);
          return;
      }
       for (int i = 0; i < 10; i++) {
           numbers[index] =(char)( i + '0');
           printRec(numbers,index+1);
       }
   }

   boolean inc(char[] number){
      char carry = 1;
      for (int i = number.length-1; i >= 0; i--) {
          if(number[i] + carry <='9'){
              number[i] =(char)(number[i] +carry);
              carry = 0;
          }else{
              number[i] = (char)((number[i]+carry - '0') % 9 + '0');
          }
      }
       return carry != 1;
   }

   String add(String a,String b){
       StringBuilder result = new StringBuilder();
       a = new StringBuilder(a).reverse().toString();
       b = new StringBuilder(b).reverse().toString();
       int carry = 0;
       int minLen = a.length() < b.length() ? a.length() : b.length();
       String maxOp = minLen == a.length() ? b :a;
       for (int i = 0; i < minLen; i++) {
           int sum = a.charAt(i) + b.charAt(i) + carry - (2*'0');
           int res = sum;
           if(sum > 9){
               res = sum  % 10;
               carry = sum / 10;
           }else {
               carry = 0;
           }
           result.append((char)(res + '0'));
       }

       for(int i=minLen;i<maxOp.length();i++){
           int sum = maxOp.charAt(i) + carry - '0';
           int res = sum;
           if(sum > 9){
               res = sum % 10;
               carry = sum / 10;
           }else {
               carry = 0;
           }
           result.append((char)(res + '0'));
       }
       if(carry > 0){
           result.append(carry + '0');
       }
       return result.reverse().toString();
   }

   void print(char[] number){
      System.out.println(String.valueOf(number));
   }
}
