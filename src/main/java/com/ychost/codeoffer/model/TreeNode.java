package com.ychost.codeoffer.model;

import sun.reflect.generics.tree.Tree;

import java.util.*;

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

      public static TreeNode create(Integer[] array){
          TreeNode root = new TreeNode(array[0]);
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
          for (int i = 1; i < array.length; i+=2) {
              TreeNode father = queue.poll();
              if(array[i] != null){
                  father.left = new TreeNode(array[i]);
                  queue.offer(father.left);
              }
              if(i+1 < array.length && array[i+1] != null){
                  father.right = new TreeNode(array[i+1]);
                  queue.offer(father.right);
              }
          }
          return root;
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

    @Override
    public String toString() {
      List<Integer> list = new ArrayList<>();
      Queue<Object> queue = new LinkedList<>();
      queue.offer(this);
      Object NULL = new Object();
      while (!queue.isEmpty()){
         int size = queue.size();
          for (int i = 0; i < size; i++) {
              Object o = queue.poll();
              if(o == NULL){
                  list.add(null);
              }else{
                  TreeNode node =(TreeNode)o;
                  list.add(node.val);
                  if(node.left == null && node.right == null){
                      continue;
                  }
                  queue.offer(node.left != null ? node.left : NULL);
                  queue.offer(node.right != null ? node.right : NULL);
              }
          }
      }
      return Arrays.toString(list.toArray());
    }
}
