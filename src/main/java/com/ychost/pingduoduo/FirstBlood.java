package com.ychost.pingduoduo;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class FirstBlood {
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        Integer[] array  =new Integer[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.valueOf(str[i]);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }

    }
}
