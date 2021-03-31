package sort.heap;

import lib.*;
//原地堆排序https://blog.csdn.net/Jae_Wang/article/details/80580095

public class heapSort {
    int maxIndex=-1;
    
    public void tran2MaxHeap(int[] items){
        maxIndex=items.length-1;
        for(int k=(maxIndex-1)/2;k>=0;k--){
            shiftDown(items,k);
        }
        
    }
    public void shiftDown(int[] items,int k){
        
        
        while(k*2+1<=maxIndex){
            int j=k*2+1;
            
            if(j+1<=maxIndex&&items[j+1]>items[j])
                j++;
            if(items[k]>=items[j])
                break;
            function.swap(items, j, k);
            k=j;
        }
         
    }
    public int extractMax(int[] items){
            int ret=items[0];
            function.swap(items, maxIndex, 0);
            maxIndex--;
            shiftDown(items,0);
            return ret;
    }
   

    public void sort(int [] items){
        tran2MaxHeap(items);
        while(maxIndex>=0){
            System.out.println(extractMax(items));
        }

    }
    public static void main(String[] args) {
        new heapSort().sort(function.generateTestArray(10, 0, 100));
    }
}
