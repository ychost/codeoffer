package com.ychost.leetcode.medium;

import com.ychost.codeoffer.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ychost
 * @date 2018/8/22
 */
public class Q236LowCommonAnc {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        if(buildPath(pPath,root,p) && buildPath(qPath,root,q)){
            List<TreeNode> maxPath = pPath;
            List<TreeNode> minPath = qPath;
            if(pPath.size() < qPath.size()){
               maxPath = qPath;
               minPath = pPath;
            }
            for (TreeNode minNode : minPath) {
                 if(maxPath.contains(minNode)){
                    return minNode;
                }
            }
        }
        return null;
    }

    boolean buildPath(List<TreeNode> path,TreeNode root,TreeNode target){
        if(root == target){
           path.add(root);
           return true;
        }
        if(root.left != null){
           if(buildPath(path,root.left,target)){
               path.add(root);
               return true;
           }
        }
        if(root.right != null){
            if(buildPath(path,root.right,target)){
                path.add(root);
                return true;
            }
        }
        return false;
    }
}
