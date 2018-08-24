package com.ychost.codeoffer;

import com.ychost.codeoffer.model.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author ychost
 * @date 2018/7/8
 */
public class PrintTreeByZTest {

    @Test
    public void printTreeByZ() {
        HashMap<Integer,TreeNode> treeMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put(i+1,new TreeNode(i+1));
        }
        treeMap.get(1).left = treeMap.get(2);
        treeMap.get(1).right = treeMap.get(3);
        treeMap.get(2).left = treeMap.get(4);
        treeMap.get(3).left = treeMap.get(5);
        treeMap.get(3).right = treeMap.get(6);
        treeMap.get(4).left = treeMap.get(7);
        treeMap.get(5).right = treeMap.get(8);
        ArrayList<ArrayList<Integer>> orderList = new PrintTreeByZ().printTreeByZ(treeMap.get(1));
        for (ArrayList<Integer> arrayList : orderList) {
            System.out.print("[");
            for (Integer val : arrayList) {
                System.out.print(val +",");
            }
            System.out.println("]");
        }

    }
}