package com.ychost.toutiao;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/8/12
 */
public class Q1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(",");
        int m = Integer.parseInt(line1[0]),n=Integer.parseInt(line1[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
       String result = countDistribute(matrix);
       System.out.println(result);
    }

    static String countDistribute(int[][]matrix){
        int isLands = 0;
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==1){
                    isLands+=1;
                    maxArea = Math.max(maxArea,dfs(matrix,i,j,0));
                }
            }
        }
        return isLands+","+maxArea;
    }

    static int dfs(int[][] matrix,int i,int j,int cnt){
        if(i>=matrix.length || j >= matrix[0].length || i< 0 || j<0 || matrix[i][j]==0){
            return cnt;
        }
        matrix[i][j] = 0;
        cnt +=1;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
               if(k == 0 && l == 0) {
                   continue;
               }
               int ti = i+k;
               int tj = j+l;
               cnt= dfs(matrix,ti,tj,cnt);
            }
        }
        return cnt;
    }

}
