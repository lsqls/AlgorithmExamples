package BST;



class bs{
    static int binarySearch(int[] arr,int target){
        int left=0,right=arr.length-1;
        //在[left,right]中查找target，极端情况：left==right,由于是闭区间，还存在元素，循环继续
        while(left<=right){
            int mid=(right-left+1)/2+left;
            System.out.println("curVal:"+arr[mid]);
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] testData={1,4,5,6,100,101,303};
        
        int index=binarySearch(testData, 5);
        System.out.println(index);
    }

}