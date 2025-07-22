import java.util.Scanner;

public class Bubble_Sort {
    public static void sort(int[] arr) {
        int n = arr.length;
        boolean swaped;

        for (int i = 0; i < n - 1; i++) {
            swaped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaped = true;

                }
            }
            if (!swaped) break;

        }

    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the  studenr");
        int n=sc.nextInt();

        int[] marks=new int[n];
        System.out.println("enter the marks of each student");
        for (int i = 0; i < n; i++) {
            marks[i]=sc.nextInt();


        }
        sort(marks);
        System.out.println("sorted mark in ascending order");
        for(int mark:marks){
            System.out.println(mark+" ");
        }
    }
}



