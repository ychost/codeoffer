package com.ychost.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ychost
 * @date 2018/8/21
 */
public class Q37SudokuSolver {
    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] block = new int[3][3];
        List<Integer> miss = new ArrayList<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i] |= (1 << num);
                    cols[j] |= (1 << num);
                    block[i / 3][j / 3] |= (1 << num);
                } else {
                    miss.add(i * 9 + j);
                }
            }
        }
        dfs(board, rows, cols, block, miss, 0);
    }

    private boolean dfs(char[][] board, int[] rows, int[] cols,
                        int[][] block, List<Integer> miss, int start) {
        if (start == miss.size()) {
            return true;
        }
        int index = miss.get(start);
        int y = index / 9;
        int x = index % 9;
        int full = 0b111111111;
        // 找到所有为 0 的位，并将其置位 1
        int candidate = full ^ (rows[y] | cols[x] | block[y / 3][x / 3]);
        while (candidate > 0) {
            // 取出最后一个不为 0 开始的数字
            // 比如 candidate = 10100 那么 bit 则为 100
            int bit = candidate & (-candidate);
            rows[y] |= bit;
            cols[x] |= bit;
            block[y / 3][x / 3] |= bit;
            if (dfs(board, rows, cols, block, miss, start + 1)) {
                // 找到候选值表示的数字，具体去请看上面的 tip
                // 比如 bit = 100  那么 bit 表示的数字是 3
                int num = 1;
                while(bit>>1 != 0){
                     bit>>=1;
                     num+=1;
                }
                board[y][x] = (char)(num + '0');
                return true;
            }
            // 进入到了这里，说明前面的候选值不满足
            // 删除之前的候选值，进入下一个候选值
            candidate -= bit;
            rows[y] -= bit;
            cols[x] -= bit;
            block[y / 3][x / 3] -= bit;
        }
        return false;
    }
}
