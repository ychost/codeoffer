package com.ychost.toutiao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author ychost
 * @date 2018/8/12
 */
public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        String[] line3 = scanner.nextLine().split(" ");
        Anchor[] anchors = new Anchor[n];
        for (int i = 0,j=0; i < n; i++) {
            anchors[i] = new Anchor();
            anchors[i].start =Integer.parseInt(line3[j++]);
            anchors[i].end =Integer.parseInt(line3[j++]);
            if(anchors[i].start>anchors[i].end){
                anchors[i].end +=m;
            }
        }
        System.out.println(countMax(anchors,m));
    }

    static int countMax(Anchor[] anchors,int m){
        List<Anchor> anchorList = Arrays.asList(anchors);
        anchorList.sort(Comparator.comparingInt(a->a.end));
        int count = 1,j=0;
        for(int i=0;i<anchorList.size();i++){
            if(anchorList.get(i).end > m){
                continue;
            }
            if(anchorList.get(i).start >= anchorList.get(j).end){
                anchorList.get(i).isSelected = true;
                j=i;
                count+=1;
            }
        }
        return count;
    }

    static class Anchor{
         public  int start;
         public int end;
         public boolean isSelected;
    }
}
