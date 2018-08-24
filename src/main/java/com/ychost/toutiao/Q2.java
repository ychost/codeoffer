package com.ychost.toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/8/12
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m =Integer.parseInt(scanner.nextLine());
        List<int[]> edit = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(";");
            for (String s : line) {
                String[] e = s.split(",");
                edit.add(new int[]{Integer.parseInt(e[0]),Integer.parseInt(e[1])});
            }

        }
        String result = mergeEdit(edit);
        System.out.println(result);
    }

    static String mergeEdit(List<int[]> edit){
        int n = edit.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = edit.get(i)[0];
            ends[i]=edit.get(i)[1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<int[]> res = new ArrayList<>();
        for(int cur=0,before=0;cur<n;cur+=1){
           if(cur == n-1 || starts[cur+1]>ends[cur]){
               res.add(new int[]{starts[before],ends[cur]});
               before = cur+1;
           }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] re : res) {
            sb.append(re[0]).append(",").append(re[1]).append(";");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
