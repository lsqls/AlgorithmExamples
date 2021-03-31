package sort;
import java.util.*;
import lib.*;
public class insertSort {
    public void insertiionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            //寻找arr[i]插入的位置
            for(int j=i;j>0&&arr[j]<arr[j-1];j--){
                function.swap(arr, j, j-1);
            }
        }
    }
    //插入排序用于接近有序的数组（日志记录）的排序，处理完全有序数组时直接退化为O(n)。希尔排序时插入排序的拓展
    public void insertiionSortPlus(int[] arr){
        for(int i=1;i<arr.length;i++){
            //寻找arr[i]插入的位置,改进版本,任何有swap函数的地方都可以进行该优化
            int curVal=arr[i];
            int j;
            for(j=i;j>0&&curVal<arr[j-1];j--){
                arr[j]=arr[j-1];
            }
            arr[j]=curVal;
        }
    }
    public static void main(String[] args) {
        insertSort solution=new insertSort();
        int[] testData=function.generateTestArray(100, 0, 100);
        solution.insertiionSort(testData);
        System.out.println(Arrays.toString(testData));


        
        testData=function.generateTestArray(100, 0, 100);
        solution.insertiionSortPlus(testData);
        System.out.println(Arrays.toString(testData));
    }
}
