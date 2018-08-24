package com.ychost.pingduoduo;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/7/22
 */
public class BallKing {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] countStr = scanner.nextLine().split(" ");
        int audiences = Integer.valueOf(countStr[1]);
        String[] tickets = new String[audiences];
        int index = 0;
        while(index != audiences){
           tickets[index++] = scanner.nextLine();
        }
        System.out.println(getKing(tickets));
    }

    static int getKing(String[] tickets){
        if(tickets.length ==1){
            return -1;
        }
       int[] scores = new int[tickets[0].length()];
        for (int i = 0; i < tickets.length; i++) {
            for(int j = 0;j<tickets[i].length();j++){
                scores[j] += 'z' - tickets[i].charAt(j);
            }
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > max){
                max = scores[i];
                index = i;
            }else if(scores[i] == max){
                index = -1;
            }
        }
        return index;
    }
}
