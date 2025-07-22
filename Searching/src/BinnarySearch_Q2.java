public class BinnarySearch_Q2 {
    public static int findPeakelement(int[] arr){
        int left=0;
        int right=arr.length-1;

        while(left<=right){
            int mid=(left+right)/2;
            boolean leftsmaller=(mid==0||arr[mid] > arr[mid - 1]);
            boolean rightsmaller=(mid== arr.length-1|| arr[mid] > arr[mid + 1]);

            if( leftsmaller && rightsmaller ){
                 return  mid;
            } else if ( mid>0 && arr[mid] < arr[mid - 1]) {
                right=mid-1;
                
            } else{
                left=mid+1;
            }
        }
        return  -1;
    }
    public static void main(String[] args) {
        int[] arr={5,6,8,2,4,5,7};
        int index=findPeakelement(arr);
        System.out.println("Peak point index: "+index);
        System.out.println("peak element: "+arr[index]);
    }

}
