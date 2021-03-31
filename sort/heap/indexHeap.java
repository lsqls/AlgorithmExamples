package sort.heap;

import lib.*;

public class indexHeap {
    int size;
    int[] data;//数据，不能swap
    
    int[] indexArray;//堆
    
    int[] reverse;//reverse[i]表示【索引i】在indexArray堆中的位置,维持reverse[indexArray[k]]=k;就行
    int capacity;
    public indexHeap(int c){
        capacity=c;
        data=new int[capacity+1];
        indexArray=new int[capacity+1];
        reverse=new int[capacity+1];
    }
    //传入 （索引，数据）对用户来说，索引从0开始
    public void insert(int index,int val){
        
        if(size==capacity||index+1<1||index+1>capacity)
            return;
        index++;
        size++;
        data[index]=val;


        indexArray[size]=index;
        reverse[indexArray[size]]=size;
        shiftUp(size);
        
    }
    //k 描述的是索引数组的位置
    public void shiftUp(int k){
        while(k>1&&data[indexArray[k]]>data[indexArray[k/2]]){
            function.swap(indexArray, k, k/2);
            reverse[indexArray[k/2]]=k/2;
            reverse[indexArray[k]]=k;
            k/=2;
        }
    }
    public int extractMax(){
        int ret=data[indexArray[1]];
        function.swap(indexArray, size, 1);
        reverse[indexArray[size]]=0;//0表示不存在堆中
        reverse[indexArray[1]]=1;
        size--;
        shiftDown(1);
        return ret;

    }
    public int extractIndexOfMax(){
        int ret=indexArray[1]-1;
        function.swap(indexArray, size, 1);
        reverse[indexArray[size]]=0;
        reverse[indexArray[1]]=1;
        size--;
        shiftDown(1);
        return ret;

    }
    public void shiftDown(int k){
        while(k*2<=size){
            int j=k*2;
            
            if(j+1<=size&&data[indexArray[k]]>data[indexArray[j]])
                j++;
            if(data[indexArray[k]]>=data[indexArray[j]])
                break;
            function.swap(indexArray, j, k);
            reverse[indexArray[j]]=j;
            reverse[indexArray[k]]=k;
            k=j;
        }
         
    }
    //例子：根据进程id号修改优先级
    public void change(int index,int val){
        index+=1;
        data[index]=val;
        int j=reverse[index];
        shiftDown(j);
        shiftUp(j);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    
    public static void main(String[] args) {
        indexHeap indexHeapInstanse=new indexHeap(30);
        int[] processes=function.generateTestArray(5, 1, 10);
        for(int i=0;i<processes.length;i++){
            indexHeapInstanse.insert(i, processes[i]);
        }
        indexHeapInstanse.change(0, 9);//把进程id号为0的优先级修改为9
        while(!indexHeapInstanse.isEmpty()){
            System.out.println(indexHeapInstanse.extractMax());
        }

    }

    
}
