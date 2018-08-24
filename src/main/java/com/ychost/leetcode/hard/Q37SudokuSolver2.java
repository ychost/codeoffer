package com.ychost.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ychost
 * @date 2018/8/21
 */
public class Q37SudokuSolver2 {
    public void solveSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col= new int[9];
        int[][] block = new int[3][3];
        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               if(board[i][j] != '.'){
                   int num = 1<<(board[i][j]-'1');
                   row[i] |= num;
                   col[j] |= num;
                   block[i/3][j/3] |= num;
               }else{
                   miss.add(i*10+j);
               }
            }
        }
        dfs(board,row,col,block,miss,0);
    }

    boolean dfs(char[][] board,int[] row,int[] col,int[][] block,List<Integer>miss,int start){
       if(start == miss.size()){
           return true;
       }
       int val = miss.get(start);
       int i = val / 10;
       int j = val % 10;
       // 9 个 1
       int full = 0b111111111;
       int cand = full ^ (row[i] | col[j] | block[i/3][j/3]);
       while(cand > 0){
          int bit = cand & -cand;
          row[i] |=bit;
          col[j] |=bit;
          block[i/3][j/3]|=bit;
          if(dfs(board,row,col,block,miss,start+1)){
              int num =1;
              while(bit>>1 !=0){
                  bit>>=1;
                  num+=1;
              }
              board[i][j]=(char)(num +'0');
              return true;
          }
          cand -=bit;
          row[i]-=bit;
          col[j]-=bit;
          block[i/3][j/3]-=bit;
       }
       return false;
    }
}
