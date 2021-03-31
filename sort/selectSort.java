
package sort;
import lib.*;
import java.util.*;
class selectSort{
    public void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=selectMin(arr, i);
            function.swap(arr, i, minIndex);
        }
    }   
    //寻找[start,length-1]中的最小值
    private int selectMin(int[] arr,int start){
        if(start>=arr.length)
            return -1;
        int minIndex=start;
        for(int i=start+1;i<arr.length;i++){
            if(arr[minIndex]>arr[i])
                minIndex=i;
        }
        return minIndex;
    }
    
    public static void main(String[] args) {
        selectSort solution=new selectSort();
        int[] testData=function.generateTestArray(100, 0, 100);
        solution.selectionSort(testData);
        System.out.println(Arrays.toString(testData));
    }
}