package com.ychost.tecent;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int A = scan.nextInt();
        int X = scan.nextInt();
        int B = scan.nextInt();
        int Y = scan.nextInt();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(getCombination(length, A, X, B, Y));
    }

    public static long getCombination(int length, int A, int X, int B, int Y) {
        int mod = 1000000007;
        int[][] dp = new int[X+Y+1][length+1];
        dp[0][0] = 1;
        for(int i=1;i<=X+Y;i++){
            for(int j=0;j<=length;j++){
                int len = i<=X ? A : B;
                if(j>=len) {
                    dp[i][j] = (dp[i - 1][j] % mod + dp[i - 1][j - len] % mod) % mod;
                }else{
                    dp[i][j] = dp[i-1][j] % mod;
                }
            }
        }

        return dp[X+Y][length] % mod;
    }
}

