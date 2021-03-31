package sort;
import lib.*;
import java.util.Arrays;
//2. 在小范围内使用插入排序（数组的小块近似有序）可以加快高级算法的排序速度
public class quickSort {
    public void qsort(int[] arr){
        qsortCore(arr, 0, arr.length-1);
    }
    public void qsortCore(int[] arr,int start,int end){
        if(start>=end)
            return;
        //返回p 使得 arr[start...p-1]< cmp 和 arr[p+1...end]>=cmp,此时p的的位置已经是最终排序数组的正确位置 
        // int p=partition(arr, start, end);

        int p=partition2(arr, start, end);

        //返回p 使得 arr[start...p-1]<= cmp 和 arr[p+1...end]>=cmp,此时p的的位置已经是最终排序数组的正确位置 
        
        qsortCore(arr,start,p-1);
        qsortCore(arr,p+1,end);


    }
    
    //维持arr[start...small]< cmp 和arr[small+1...i)>=cmp 
    public int partition(int[] arr,int start,int end){
        //原始的快速排序调用递归所形成的二叉树的平衡度比归并排序差，所以在排序近似有序的数组时快速排序速度较慢，最差可以退化为o(n^2),所以需要随机选取比较值（此时算法复杂度的【期望】是o(nlogn)）
        
        function.swap(arr, start, (int)(Math.random()*(end-start+1))+start);//这里容易出现bug
        
        int cmp=arr[start];
        int small=start;
        for(int i=start+1;i<=end;i++){
            if(arr[i]<cmp){
                function.swap(arr, ++small, i);
                
            }
        }
        function.swap(arr, small, start);
        
        return small;
    }


    //存在大量重复元素，可以使用双路快排，重复的比较元素大概率均分在两侧，使得快排的平衡性得以维持
    //维持arr[start+1...i)< =cmp 和arr(j...end]>=cmp 
    public int partition2(int[] arr,int start,int end){
        
        function.swap(arr, start, (int)(Math.random()*(end-start+1))+start);//这里容易出现bug
        
        int cmp=arr[start];


        int i=start+1,j=end;

        while(true){
            while(i<=end&&arr[i]<cmp)
                i++;
            while(j>=start+1&&arr[j]>cmp)
                j--;
            if(i>j)
                break;
            function.swap(arr, i, j);
            i++;
            j--;

        }
        function.swap(arr, start, j);
        return j;
    }

    //系统一般使用三路快排
    //当前考察元素arr[i]
    //维护：arr[start+1,lt]<cmp ,arr[lt+1,i) =v,arr[gt,end]>cmp
    public void qSort3Ways(int[] arr,int start,int end){
        //记得写边界处理
        if(start>=end)
            return;
        function.swap(arr, start, (int)(Math.random()*(end-start+1))+start);//这里容易出现bug
        
        int cmp=arr[start];
        int lt=start,gt=end+1;
        int i=lt+1;
        while(i<gt){
            if(arr[i]<cmp ){
                function.swap(arr, i, lt+1);
                lt++;
                i++;
            }
            else if(arr[i]==cmp)
                i++;
            else{
                function.swap(arr, i, gt-1);
                gt--;
            }            
        }
        function.swap(arr, start, lt);
        lt--;
        qSort3Ways(arr, start, lt);
        qSort3Ways(arr, gt, end);

    }
    public static void main(String[] args) {
        quickSort solution=new quickSort();
        int[] testData=function.generateTestArray(100, 0, 100);
        solution.qsort(testData);
        System.out.println(Arrays.toString(testData));
        
        testData=function.generateTestArray(100 , 0, 100);
        solution.qSort3Ways(testData, 0, testData.length-1);
        System.out.println(Arrays.toString(testData));

    }
}
