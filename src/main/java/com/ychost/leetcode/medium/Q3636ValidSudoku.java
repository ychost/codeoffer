package com.ychost.leetcode.medium;

import java.util.BitSet;

/**
 * @author ychost
 * @date 2018/8/21
 */
public class Q3636ValidSudoku {
    public boolean isValidSudoku2(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.'){
                    int num = board[i][j]- '1';
                    int bi = (i / 3)*3 + j / 3;
                    if(row[i][num] || column[j][num] || block[bi][num]){
                        return false;
                    }
                    row[i][num]= column[j][num]= block[bi][num] = true;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        char[] colums = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            if(!validLine(board[i])){
                return false;
            }
        }
        for(int j=0;j<board[0].length;j++){
            for(int i=0;i<board.length;i++){
                colums[i] = board[i][j];
            }
            if(!validLine(colums)){
                return false;
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                if(!validGrid(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean validGrid(char[][] board,int si,int sj){
        BitSet bs = new BitSet(9);
        for(int i=si;i<si+3;i++){
            for(int j=sj;j<sj+3;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(bs.get(board[i][j]-'0')){
                    return false;
                }
                bs.set(board[i][j]-'0',true);
            }
        }
        return true;
    }

    boolean validLine(char[] line){
        BitSet bs = new BitSet(9);
        for (int i = 0; i < line.length; i++) {
            if(line[i] == '.'){
                continue;
            }
            if(bs.get(line[i]-'0')){
                return false;
            }
            bs.set(line[i]-'0',true);
        }
        return true;
    }
}
