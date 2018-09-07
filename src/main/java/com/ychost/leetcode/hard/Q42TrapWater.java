package com.ychost.leetcode.hard;

import java.util.HashMap;

/**
 * @author ychost
 * @date 2018/9/4
 */
public class Q42TrapWater {
    public int trap(int[] height) {
        int leftMax =0,rightMax =0,ans = 0,l=0,r=height.length-1;
        while(l<r){
            if(height[l] < height[r]){
                if(height[l] >= leftMax){
                    leftMax = height[l];
                }else{
                    ans += (leftMax - height[l]);
                }
                ++l;
            }else{
                if(height[r] >= rightMax){
                    rightMax = height[r];
                }else{
                    ans += (rightMax - height[r]);
                }
                --r;
            }
        }
        return ans;
    }

    public int trap2(int[] heights){
        if(heights == null || heights.length == 0){
            return 0;
        }
        int[] leftMax  = new int[heights.length];
        int[] rightMax = new int[heights.length];
        leftMax[0] = heights[0];
        rightMax[heights.length-1] = heights[heights.length-1];
        for(int i=1;i<heights.length;i++){
           leftMax[i] = Math.max(leftMax[i-1],heights[i]);
        }
        for(int j=heights.length-2;j>=0;j--){
            rightMax[j] = Math.max(rightMax[j+1],heights[j]);
        }
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
           ans += Math.min(leftMax[i],rightMax[i]) - heights[i];
        }
        return ans;
    }
}
