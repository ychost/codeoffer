package com.ychost.leetcode.medium;

/**
 * @author ychost
 * @date 2018/9/5
 */
public class Q11ContainerMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2){
            return 0;
        }
        int ans =0,l=0,r=height.length-1;
        while (l<r){
            ans  = Math.max(ans,Math.min(height[l],height[r]) * (r-l));
            if(height[r] > height[l]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}
