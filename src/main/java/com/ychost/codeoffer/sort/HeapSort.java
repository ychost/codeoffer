package com.ychost.codeoffer.sort;

/**
 * @author ychost
 * @date 2018/7/14
 */
public class HeapSort extends AbstractSort {
    @Override
    protected void sortCall(int[] array) {
        new MinHeap(array).bigToSmallSort();
        for (int i = 0; i < array.length/2; i++) {
            SortUtils.swap(array,i,array.length -1 -i);
        }
    }

    class MinHeap{
        int[] array;
        int size = 0;
        public MinHeap(int[] array){
           this.array = array;
           size = array.length;
           init();
        }

        void bigToSmallSort(){
            int n = size;
            while(size>1){
                SortUtils.swap(array,0,size-1);
                --size;
                shiftdown(0);
            }
            size = n;
        }

        void init(){
            // 从最后一层非叶子节点开始下沉
            for(int i = (size-1) / 2;i >= 0;i--){
                shiftdown(i);
            }
        }

        /**
         * 将某个节点向上移动
         * @param i
         */
        void shiftup(int i){
           if(i <= 0){
               return;
           }
           int fatherIndex = (i-1)/2;
           if(array[i] < array[fatherIndex]){
               SortUtils.swap(array,i,fatherIndex);
               shiftup(fatherIndex);
           }
        }

        /**
         * 将某个节点向下移
         * @param i
         */
        void shiftdown(int i){
            int leftIndex  = 2 * i + 1;
            int rightIndex = 2 * i + 2;
            if(leftIndex >= size){
                return;
            }
            int minIndex = leftIndex;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }

            if(array[i] > array[minIndex]){
                SortUtils.swap(array,i,minIndex);
                shiftdown(minIndex);
            }
        }

        /**
         * 添加一个节点，即将节点添加到末尾，然后上移
         * @param val
         */
        void offer(int val){
           ensure(size+1);
           array[size-1] = val;
           shiftup(size -1);
        }

        /**
         * 删除堆顶元素，即最小值
         * 将堆顶和堆尾元素交换，然后删除堆尾，然后下层堆顶元素
         * @return
         */
        int poll(){
           int result = array[0];
           array[0] = array[size-1];
           size -=1;
           shiftdown(0);
           return result;
        }

        void ensure(int minSize){
           if(size < minSize){
               int[] newArray = new int[minSize];
               System.arraycopy(array,0,newArray,0,size);
               array = newArray;
               size = minSize;
           }
        }


    }
}
