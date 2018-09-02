package com.ychost.learn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        System.out.println(exchange(expr));
    }



    public static int exchange(String s){
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            int j = i;
            while (j - 1 >= 0 && chs[j]=='C' && chs[j - 1] == 'D') {
                swap(chs,j,j-1);
                j-=1;
                count+=1;
            }
        }
        return count;
    }

   static void swap(char[] array,int i,int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
