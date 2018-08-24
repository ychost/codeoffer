package com.ychost.codeoffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指Offer 面试题 12，矩阵中的路径
 * @author ychost
 * @date 2018/7/7
 */
public class Q12RouteInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null || matrix.length ==0 || matrix.length != rows * cols || matrix.length < str.length){
            return false;
        }
        boolean[] mark = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i] == str[0]){
                int si = i / cols;
                int sj = i % cols;
                 Arrays.fill(mark,false);
                if(hasRoute(matrix,si,sj,rows,cols,0,str,mark)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean hasRoute(char[] matrix,int i,int j,int rows,int cols,int index,char[] str,boolean[] mark){
       if(index == str.length){
            return true;
       }
       if(i < 0 || j < 0 || i >= rows || j >= cols ||mark[i*cols+j]|| matrix[i*cols + j] != str[index]){
           return false;
       }
       index +=1;
       mark[i*cols+j] = true;
       for (int[] node : next) {
            int ti = node[0] + i;
            int tj = node[1] + j;
            if(hasRoute(matrix, ti, tj, rows, cols, index, str,mark)){
                return true;
            }
        }
       return false;
    }

    int[][] next = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
}
