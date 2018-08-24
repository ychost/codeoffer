package com.ychost.toutiao;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/8/12
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] poker = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            poker[i][0] = Integer.parseInt(line[0]);
            poker[i][1] = Integer.parseInt(line[1]);
        }
        System.out.println(getMaxTeamIntegral(poker));
    }

    static int getMaxTeamIntegral(int[][] poker){
        int xMax = 0;
        for (int[] p : poker) {
           xMax += p[0];
        }
        xMax/=2;
        int[][] dp = new int[poker.length+1][xMax] ;
        int maxResult = 0;
        for (int i = 0; i < poker.length; i++) {
            int x = poker[i][0];
            int y = poker[i][1];
            for (int j = 1; j < xMax; j++) {
                int a = dp[i-1][j];
                int b = 0;
                if(j>x && dp[i][j-x]>0) {
                     b = dp[i][j - x] + y;
                }
                dp[i][j] = Math.max(a,b);
                maxResult= Math.max(dp[i][j],maxResult);
            }
        }
        return maxResult;
    }
}
