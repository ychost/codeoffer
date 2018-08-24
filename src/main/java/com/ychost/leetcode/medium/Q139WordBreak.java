package com.ychost.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ychost
 * @date 2018/8/22
 */
public class Q139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s,wordDict);
    }

    Set<String> set = new HashSet<>();
    boolean dfs(String target,List<String> wordDict){
        if(target.length() == 0){
            return true;
        }
        if(wordDict.contains(target)){
            return true;
        }
        if(set.contains(target)){
            return false;
        }
        for (String word : wordDict) {
            if (target.startsWith(word)) {
                if(dfs(target.substring(word.length()),wordDict)){
                    return true;
                }
            }

        }
        set.add(target);
        return false;
    }
}
