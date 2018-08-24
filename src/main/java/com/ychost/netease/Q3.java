package com.ychost.netease;

import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/8/11
 */
public class Q3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int s = calc(m,n);
        if(s < k){
            System.out.println("-1");
        }else{
            StringBuilder sb = new StringBuilder();
            solve(m,n,sb,k);
            System.out.println(sb.toString());
        }

    }

    public static int calc(int m, int n){
        int maxNum = 1;
        int mm = Math.max(m, n);
        int nn = Math.min(m, n);
        for(int i = m + n; i > mm; i --){
            maxNum*= i;
        }
        for(int i = 1; i <= nn; i ++){
            maxNum/= i;
        }
        return maxNum;
    }
    public static void solve(int m, int n,StringBuilder sb, int k){

        if(n < 0 || m < 0) {
            return;
        }
        if(m == 0 && n == 0) {
            return ;
        }
        if( k == 0){
            while(m > 0){
                sb.append("z");
                m --;
            }

            while(n > 0) {
                sb.append("a");
                n--;
            }
            return ;
        }
        if(n > 0 && calc(m, n - 1) > k){
            sb.append("a");
            solve(m, n - 1, sb, k);
        }
        else if(n > 0 && calc(m, n - 1) < k){
            sb.append("z");
            solve(m - 1, n, sb, k - calc(m, n - 1));
        }
        else if(n > 0 && calc(m, n - 1) == k){
            sb.append("a");
            solve(m, n - 1, sb, 0);
        }
    }



}
