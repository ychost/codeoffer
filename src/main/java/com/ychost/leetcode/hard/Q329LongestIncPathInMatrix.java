package com.ychost.leetcode.hard;

/**
 * @author ychost
 * @date 2018/9/5
 */
public class Q329LongestIncPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix== null || matrix.length == 0 || matrix[0].length ==0){
            return 0;
        }
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               res = Math.max(res,find(i,j,matrix,cache));
            }
        }
        return res;
    }


    int[][] next = {{0,1},{0,-1},{-1,0},{1,0}};
    int find(int i,int j,int[][] matrix,int[][] cache){
        if(cache[i][j] != 0){
            return cache[i][j];
        }

        int len = 1;
        for (int[] step : next) {
            int ti = i + step[0];
            int tj = j + step[1];
            if(ti <0 || tj <0 || ti >=matrix.length || tj >= matrix[0].length) {
                continue;
            }
            if(matrix[ti][tj] > matrix[i][j]) {
                len = Math.max(len,find(ti,tj,matrix,cache)+1);
            }
        }
        cache[i][j] = len;
        return len;
    }
}
