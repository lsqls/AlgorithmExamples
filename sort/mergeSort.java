package sort;
import lib.*;
import java.util.Arrays;
//自底向上的归并排序可以实现o(nlogn)的链表排序
//分治为o(logn)层，每层的合并时间复杂度为o(n)
public class mergeSort {
    public void  mergeSortArr(int[] arr){
        mergeSortArrCore(arr,0,arr.length-1);
    }
    //对[left,right]中的元素进行排序
    public void mergeSortArrCore(int[] arr,int left,int right){
        //必要的退出条件
        if(left>=right)
            return;
        int mid=(left+right)/2;
        
        mergeSortArrCore(arr, left, mid);
        mergeSortArrCore(arr, mid+1, right);
        //归并排序的优化，1. 检查是否能够跳过合并步骤 2. 在小范围内使用插入排序（此时数组的小块大概率接近排序）
        if(arr[mid]>arr[mid+1])
            merge(arr,left,mid,right);
    }
    //合并【left，mid】和【mid+1，right】两个排序数组
    public void merge(int[] arr,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        // int mid=(left+right)/2;
        int index1=left,index2=mid+1;
        for(int i=0;i<temp.length;i++){
            if(index1>mid)
                temp[i]=arr[index2++];
            else if(index2>right)
                temp[i]=arr[index1++];
            else if(arr[index1]<arr[index2])
                temp[i]=arr[index1++];
            else
                temp[i]=arr[index2++];   
        }
        for(int i=0;i<temp.length;i++){
            arr[i+left]=temp[i];
        }
        
        
    }
    public static void main(String[] args) {
        mergeSort solution=new mergeSort();
        int[] testData=function.generateTestArray(100, 0, 100);
        solution.mergeSortArr(testData);
        System.out.println(Arrays.toString(testData));
    }

}
