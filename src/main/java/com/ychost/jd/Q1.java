package com.ychost.jd;

import java.util.*;

/**
 * @author ychost
 * @date 2018/9/9
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t =Integer.parseInt(scanner.nextLine());
        String[] res = new String[t];
        for (int j = 0; j < t; j++) {
            degreeCount = 0;
            String[] line = scanner.nextLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                String[] strs = scanner.nextLine().split(" ");
                int a = Integer.parseInt(strs[0]);
                int b = Integer.parseInt(strs[1]);
                if (!map.containsKey(a)) {
                    map.put(a, new ArrayList<>());
                }
                if (!map.containsKey(b)) {
                    map.put(b, new ArrayList<>());
                }
                map.get(a).add(b);
                map.get(b).add(a);
            }
            res[j] = isCompleteGraph(map,n,m) ?"Yes":"No";
        }
        for (String s : res) {
            System.out.println(s);
        }
    }




    static boolean isCompleteGraph(Map<Integer,List<Integer>> map,int n,int m){
        boolean[] mark = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if(map.containsKey(i) && !mark[i]) {
                    degreeCount = 0;
                    countDegree(map, mark, i);
                    if(degreeCount != 2 * map.get(i).size() +1){
                        return false;
                    }

                }
            }
            return true;
    }


  private static int degreeCount;
  private static void countDegree(Map<Integer, List<Integer>> map, boolean[] mark, int v){
       degreeCount +=1;
       mark[v]=true;
       for(int i=0;i<map.get(v).size();i++){
           if(!mark[map.get(v).get(i)]){
               countDegree(map,mark,map.get(v).get(i));
           }
       }
    }
}
