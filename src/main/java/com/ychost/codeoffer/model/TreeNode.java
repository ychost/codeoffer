package com.ychost.codeoffer.model;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ychost
 * @date 2018/7/7
 */
public class TreeNode {
      public  int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }

      public static Map<Integer,TreeNode> create(int[] array){
            Map<Integer,TreeNode> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                 map.put(i,new TreeNode(array[i]));
            }
            return map;
      }

      public static void setSubTree(Map<Integer,TreeNode> map,Integer father,Integer left,Integer right){
          if(!map.containsKey(father)){
              map.put(father,new TreeNode(father));
          }
          if(left != null) {
              if(!map.containsKey(left)){
                 map.put(left,new TreeNode(left));
              }
              map.get(father).left = map.get(left);
          }else{
              map.get(father).left = null;
          }
          if(right != null) {
              if(!map.containsKey(right)){
                  map.put(right,new TreeNode(right));
              }
              map.get(father).right = map.get(right);
          }else{
              map.get(father).right = null;
          }
      }

}
