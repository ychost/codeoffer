package com.ychost.toutiao;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/8/12
 */
public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] line2 = scanner.nextLine().split(" ");
        String[] line3 = scanner.nextLine().split(" ");
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(line2[i]);
            b[i] = Integer.parseInt(line3[i]);
        }
        System.out.println(countInterval(a,b));
    }

   static int countInterval(int[] a,int[] b){
        int n = a.length;
        int[][] maxA = new int[n][n];
        int[][] minB = new int[n][n];
        for (int i = 0; i < n; i++) {
            int max = a[i];
            int min = b[i];
            for(int j=i;j<n;j++){
                max = Math.max(max,a[j]);
                min = Math.min(min,b[j]);
                maxA[i][j] = max;
                minB[i][j] = min;
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(maxA[i][j]<minB[i][j]){
                   count+=1;
                }
            }
        }
        return count;
    }
}
