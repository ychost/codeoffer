package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.TreeNode;

public class Q98ValidBST {

    public boolean isValidBST2(TreeNode root){
       return dfs(root,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY);
    }

    boolean dfs(TreeNode root,double max,double min){
       if(root == null){
           return true;
       }
       if(root.val <= min || root.val >= max){
           return false;
       }
       return dfs(root.left,root.val,min) && dfs(root.right,max,root.val);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Integer leftMax = getMaxVal(root.left);
        Integer rightMin = getMinVal(root.right);
        if((leftMax != null && root.val <= leftMax) ||(rightMin != null &&root.val >= rightMin)){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }


    public Integer getMaxVal(TreeNode root){
        if(root == null){
            return null;
        }
        Integer maxVal = max(getMaxVal(root.left),getMaxVal(root.right));
        return max(maxVal,root.val);
    }

    public Integer getMinVal(TreeNode root){
       if(root == null){
           return  null;
       }
       Integer minVal = min(getMinVal(root.left),getMinVal(root.right));
       return min(minVal,root.val);
    }


    Integer max(Integer a,Integer b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        return Math.max(a,b);
    }

    Integer min(Integer a,Integer b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        return Math.min(a,b);
    }
}
