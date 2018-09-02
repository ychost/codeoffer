package com.ychost.toutiao;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void put() {
        LRUCache<Integer,Integer> cache = new LRUCache<>(3);
        for(int i =0;i<3;i++){
            cache.put(i,i);
        }
        System.out.println(cache.get(1));
        cache.put(4,4);
        cache.put(5,5);
        cache.remove(4);

        System.out.println(cache.get(2));
    }
}