package com.ychost.yy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] l1= scanner.nextLine().split(" ");
        String l2 = scanner.nextLine();
        int[] foods  = new int[l1.length];
        for (int i = 0; i < l1.length; i++) {
            foods[i]= Integer.parseInt(l1[i]);
        }
        int h = Integer.parseInt(l2);
        System.out.println(getMinSpeed(foods,h));
    }

    static int getMinSpeed(int[] foods,int h){
        int[][] dp = new int[foods.length][h+1];
        for(int i=0;i<foods.length;i++){
            for(int j=0;j<=h;j++){
                if(j==0){
                    dp[i][j] = Integer.MAX_VALUE;
                }else{
                    int time = 1;
                    while(j*time < foods[i]){
                        time+=1;
                    }
                    int pre = 0;
                    if(i>0){
                        pre = dp[i-1][j];
                    }
                    dp[i][j] = pre +  time;
                }
            }
        }

        int minSpeed = Integer.MAX_VALUE;
        for(int i=0;i<=h;i++){
            if(dp[foods.length-1][i] <= h){
                minSpeed =  i;
                break;
            }
        }
        return minSpeed;
    }


}
