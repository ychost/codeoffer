package com.ychost.meituan;

import java.util.*;

/**
 * @author ychost
 * @date 2018/9/6
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            String[] strs = scanner.nextLine().split(" ");
            int start = Integer.parseInt(strs[0])-1;
            int end = Integer.parseInt(strs[1])-1;
            if (!map.containsKey(start)) {
                map.put(start, new ArrayList<>());
            }
            if(!map.containsKey(end)){
                map.put(end,new ArrayList<>());
            }
            map.get(start).add(end);
            map.get(end).add(start);
        }
        System.out.println(minSteps(map,n));
    }





    public static   int minSteps(Map<Integer,List<Integer>> graph,int n) {
        int[][] dp = new int[n][1<<n];
        Queue<State> queue =  new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1<<i]=0;
        }
        queue.offer(new State(0x01,0));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            List<Integer> negs = graph.get(state.source);
            if(negs == null){
                continue;
            }
            for (int next : negs) {
                int nextMask = state.mask | 1 << next;
                if (dp[next][nextMask] > dp[state.source][state.mask]+1) {
                    dp[next][nextMask] = dp[state.source][state.mask]+1;
                    queue.offer(new State(nextMask, next));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i][(1<<n)-1]);
        }
        return res-1;
    }

   static class State {
        public int mask, source;
        public State(int m, int s) {
            mask=m;
            source=s;
        }
    }
}
