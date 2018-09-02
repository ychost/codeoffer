package com.ychost.codeoffer.model;

import java.util.HashMap;
import java.util.Map;

public class RandomListNode {
    public   int label;
    public       RandomListNode next, random;
    public   RandomListNode(int x) { this.label = x; }
    public static Map<Integer,RandomListNode> create(int[] array){
        Map<Integer,RandomListNode> map = new HashMap<>();
        Integer preLabel = null;
        for (int label : array) {
            RandomListNode node = new RandomListNode(label);
            map.put(label,node);
            if(preLabel != null){
                map.get(preLabel).next= map.get(label);
            }
            preLabel = label;
        }
        return map;
    }
}
