import java.util.Scanner;

public class LinearSearch_Q1 {
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array from start to end
        for (int i = 0; i < arr.length; i++) {
            // Check if current_element is negative
            if (arr[i] < 0) {
                return i; // Return index of first negative number
            }
        }
        // If no negative number found, return -1
        return -1;
    }



    public static void main(String[] args) {
       Scanner n= new Scanner (System.in);
        System.out.print("Enter the size of the array: ");
        int size = n.nextInt();

        // Initialize array with the specified size
        int[] arr = new int[size];

        // Get array elements from user
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = n.nextInt();
        }

        // Call the method to find first negative number
        int result = findFirstNegative(arr);

        // Display the result
        if (result != -1) {
            System.out.println("First negative number found at index: " + result);
            System.out.println("Value: " + arr[result]);
        } else {
            System.out.println("No negative number found in the array.");
        }

    }
}
