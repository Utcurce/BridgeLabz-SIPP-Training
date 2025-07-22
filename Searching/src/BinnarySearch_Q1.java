import java.util.Scanner;

public class BinnarySearch_Q1 {
  public static  int findrotationpoint(int[] arr){
      int left=0;
      int right=arr.length-1;
      while(left<right){
          int mid=(left+right)/2;

          if(arr[mid]>arr[right]){
              left=mid+1;

          } else {
              right=mid;
              
          }

      }
      return  left;

  }

    public static void main(String[] args) {
        int[] arr={5,6,8,2,4,5,7};
        int index=findrotationpoint(arr);
        System.out.println("Rotation point index: "+index);
        System.out.println("smallest element: "+arr[index]);
    }


}
