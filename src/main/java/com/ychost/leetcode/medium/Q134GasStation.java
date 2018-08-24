package com.ychost.leetcode.medium;

/**
 * @author ychost
 * @date 2018/8/23
 */
public class Q134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if(canRun(gas,cost,i)){
                return i;
            }
        }
        return -1;
    }

    boolean canRun(int[] gas,int[] cost,int start){
        int rsv = 0;
        for(int i=start;i<gas.length;i++){
           rsv += gas[i];
           rsv -= cost[i];
           if(rsv < 0){
               return false;
           }
        }
        for(int i=0;i<start;i++){
           rsv += gas[i];
           rsv -= cost[i];
           if(rsv < 0){
               return false;
           }
        }
        return true;
    }


}
