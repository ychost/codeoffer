package com.ychost.jd;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/9/9
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] props = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] strs = scanner.nextLine().split(" ");
            props[i] = new int[3];
            for (int j = 0; j < strs.length; j++) {
                props[i][j] = Integer.parseInt(strs[j]);
            }
        }
        System.out.println(countFailed(props));
    }

    static int countFailed(int[][] props){
        int count = 0;
        boolean[] mark = new boolean[props.length];
        for (int i = 0; i < props.length; i++) {
            for(int j=i+1;j<props.length;j++){
                if(!mark[i]) {
                    if (props[i][0] < props[j][0] &&
                        props[i][1] < props[j][1] &&
                        props[i][2] < props[j][2]) {
                        count += 1;
                        mark[i] = true;
                    }
                }
                if(!mark[j]){
                    if (props[i][0] > props[j][0] &&
                        props[i][1] > props[j][1] &&
                        props[i][2] > props[j][2]) {
                        count += 1;
                        mark[j] = true;
                    }
                }
            }
        }
        return count;
    }

}
