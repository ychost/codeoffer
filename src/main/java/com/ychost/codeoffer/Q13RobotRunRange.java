package com.ychost.codeoffer;

/**
 * 剑指Offer 面试题 13，机器人运动范围
 * @author ychost
 * @date 2018/7/8
 */
public class Q13RobotRunRange {
    public int movingCount(int threshold, int rows, int cols) {
        if(threshold < 0 || rows <=0 | cols <=0){
            return 0;
        }
        boolean[][] mark = new boolean[rows][cols];
        return  run(0,0,rows,cols,threshold,mark);
    }

    int[][] next = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int sum =0;
    int run(int i,int j,int rows,int cols,int threshold,boolean[][] mark){
       if(i < 0 || j< 0 || i >= rows || j >= cols || mark[i][j] || !canRun(i,j,threshold)){
           return 0;
       }
       mark[i][j] = true;
       sum +=1;
       for (int[] nxt : next) {
            int ti = nxt[0] + i;
            int tj = nxt[1] + j;
            run(ti, tj, rows, cols, threshold, mark);
       }
       return sum;
    }


    boolean canRun(int i,int j,int threshold){
        int sum = 0;
        while(i > 0){
           sum += i % 10;
           i/=10;
        }
        while(j > 0){
           sum += j % 10;
           j /= 10;
        }
       return sum <= threshold;
    }
}

