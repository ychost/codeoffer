package com.ychost.toutiao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V>  {
    private final int maxSize;
    private Entry first;
    private Entry last;
    private HashMap<K, Entry> map;
    public LRUCache(int maxSize){
        this.maxSize = maxSize;
        map = new HashMap<>();
    }

    public void put(K k,V v){
       Entry entry = getEntry(k);
       if(entry == null){
           if(map.size() >= maxSize){
               map.remove(last.key);
               removeLast();
           }
           entry = new Entry();
           entry.key =k;
       }
       entry.value = v;
       moveToFirst(entry);
       map.put(k,entry);
    }

    public V get(K k){
        Entry entry = getEntry(k);
        if(entry == null){
            return null;
        }
        moveToFirst(entry);
        return entry.value;
    }

    public Entry remove(K k){
        Entry entry = getEntry(k);
        if(entry != null){
            if(entry.pre != null){
                entry.pre.next = entry.next;
            }
            if(entry.next != null){
                entry.next.pre = entry.pre;
            }
            if(entry == first){
                first= entry.next;
            }
            if(entry == last){
                last = entry.pre;
            }
        }
        StringBuilder sb = new StringBuilder();

        map.remove(k);
        return entry;
    }


    private Entry getEntry(K k){
        return map.get(k);
    }

    private void removeLast(){
       if(last != null){
           last = last.pre;
           if(last == null){
               first = null;
           }else{
               last.next = null;
           }
       }
    }

    private void moveToFirst(Entry entry){
       if(entry == null){
           return;
       }
       if(entry.pre != null){
           entry.pre.next = entry.next;
       }
       if(entry.next != null){
           entry.next.pre = entry.pre;
       }
       if(first == null || last == null){
           first = last = entry;
           return;
       }
       entry.next = first;
       first.pre = entry;
       first = entry;
       entry.pre = null;
    }

    class Entry{
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }
}
