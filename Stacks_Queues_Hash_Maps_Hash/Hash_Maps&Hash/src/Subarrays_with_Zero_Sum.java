import java.util.*;
public class Subarrays_with_Zero_Sum {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1); // For subarrays starting from index 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Subarrays with zero sum:");
        for (int[] range : subarrays) {
            System.out.println("From index " + range[0] + " to " + range[1]);
        }
    }
}
