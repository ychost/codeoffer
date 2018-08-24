package com.ychost.codeoffer;

import java.util.PriorityQueue;

/**
 * 剑指Offer 面试题 41，数据流的中位数
 * @author ychost
 * @date 2018/7/15
 */
public class Q41StreamMedian {
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((s,v)->v-s);
    public Q41StreamMedian(){
    }

    /**
     * 维护两个堆，最大堆和最小堆，最大堆_中间值_最小堆
     * 及最大堆的最大值 < 最小堆的最小值
     * 两个堆的元素个数相当的时候那么中间元素就是最大堆的堆顶元素，或者 两个堆的堆顶元素的平均值
     * 因为先插入的最大堆
     * @param num
     */
    public void Insert(Integer num) {
        // 总数为偶数，往 maxQueue 里面插
       if(((maxQueue.size() + minQueue.size()) & 1) ==0){
           // 直接插入
            if(maxQueue.size() == 0){
                maxQueue.offer(num);
                return;
            }
            // 如果待插入值比最小堆的最小值大，则将值插入最小堆
           int maxNum = num;
            if(num > minQueue.peek()){
                maxNum = minQueue.poll();
                minQueue.offer(num);
            }
            maxQueue.offer(maxNum);
           // 往 minQueue 里面插
       }else{
           int minNum = num;
           // 插入值比最大堆的最大值还要小
           // 则将最大堆的最大值和插入值互换
           if(num < maxQueue.peek()){
               minNum = maxQueue.poll();
               maxQueue.offer(num);
           }
           minQueue.offer(minNum);
       }
    }

    public Double GetMedian() {
        if(((maxQueue.size() + minQueue.size()) & 1) == 0){
           return (((double)maxQueue.peek() + (double)minQueue.peek()) / 2);
        }
        return Double.valueOf(maxQueue.peek());
    }
}
