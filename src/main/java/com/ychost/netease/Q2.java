package com.ychost.netease;

import java.util.*;

/**
 * @author ychost
 * @date 2018/8/11
 */
public class Q2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String[] line2 = scanner.nextLine().split(" ");
        String line3 = scanner.nextLine();
        String[] line4 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line1),m=Integer.parseInt(line3);
        int[] A = new int[n];
        for (int i = 0; i < n;i++) {
            A[i] = Integer.parseInt(line2[i]);
        }
        int[] Q = new int[m];
        for(int i=0;i<m;i++){
           Q[i] = Integer.parseInt(line4[i]);
        }
        int[] result = getAppleBelong(A,Q);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] getAppleBelong(int[] A,int[] Q){
        int[] result = new int[Q.length];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < Q.length; i++) {
            if(!map.containsKey(Q[i])){
                map.put(Q[i],new ArrayList<>());
            }
            map.get(Q[i]).add(i);
        }
        int[] ques = new int[Q.length];
        System.arraycopy(Q,0,ques,0,Q.length);
        Arrays.sort(ques);
        int j = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if(j>=ques.length){
                break;
            }
            sum+=A[i];
            if(sum>=ques[j]){
                List<Integer> list = map.get(ques[j]);
                for (Integer idx : list) {
                    result[idx]=i+1;
                    j+=1;
                }
            }
        }
        return result;
    }
}
