package sort.heap;





import lib.*;

public class maxHeap {
    int size;
    int[] data;
    int capacity;
    public maxHeap(int capacity){
        data=new int[capacity+1];
        size=0;
        this.capacity=capacity;
        // data[size]=-1;
    }
    public void insert(int val){
        if(size==capacity)
            return;
        size++;
        data[size]=val;
        shiftUp(size);
        
    }
    public void shiftUp(int k){
        while(k>1&&data[k]>data[k/2]){
            function.swap(data, k, k/2);
            k/=2;
        }
    }
    public int extractMax(){
        int ret=data[1];
        function.swap(data, size, 1);
        
        size--;
        shiftDown(1);
        return ret;

    }
    public void shiftDown(int k){
        while(k*2<=size){
            int j=k*2;
            
            if(j+1<=size&&data[j+1]>data[j])
                j++;
            if(data[k]>=data[j])
                break;
            function.swap(data, j, k);
            k=j;
        }
         
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    
    //heapify，在data数组的[items.length/2,1]的节点上执行shiftdown 操作，整个过程的算法复杂度为o(n)，而将n个元素逐一插到一个空堆中，算法复杂度o(nlogn)
    public maxHeap(int[] items){
        int length=items.length;
        data=new int[length*2];
        data[0]=-1;
        for(int i=0;i<length;i++){
            data[i+1]=items[i];
        }
            
        size=length;
        
        for(int k=size/2;k>=1;k--){
            shiftDown(k);
        }

    }
    
    public static void main(String[] args) {
        int[] testData=function.generateTestArray(10, 0, 100);
        maxHeap maxHeapInstanse=new maxHeap(999);
        //将n个元素逐一插到一个空堆中，算法复杂度o(nlogn)
        for(int val:testData)
            maxHeapInstanse.insert(val);
        while(!maxHeapInstanse.isEmpty()){
            System.out.println(maxHeapInstanse.extractMax());
        }
        testData=function.generateTestArray(10, 0, 100);
        maxHeap maxHeapInstanse2=new maxHeap(testData);
        while(!maxHeapInstanse2.isEmpty()){
            System.out.println(maxHeapInstanse2.extractMax());
        }
        
        
            

    }
       

}
