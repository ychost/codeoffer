package com.ychost.pingduoduo;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class CopyCola {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[]{"Alice", "Bob", "Cathy", "Dave"};
        int index = getLastIndex(n);
        System.out.println(array[index]);
    }

    static int getLastIndex(int n){
        int power = 1;
        int inv = 0;
        int pre = power;
        while(4*(power-1) < n){
           pre= power;
           power *=2;
           if(inv == 0 ){
               inv = 1;
           }else {
               inv *= 2;
           }
        }
        power = pre;
        int diff= n -  (power -1)*4;
        int index = diff/inv -1 ;
        return index <0 ? 0 : index;
    }
}
