import java.util.*;

public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int cumulativeSum = 0;
        map.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle subarray starting from index 0
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];
            if (map.containsKey(cumulativeSum)) {
                for (int start : map.get(cumulativeSum)) {
                    result.add(new int[]{start + 1, i}); // Store start and end indices of subarray
                }
            }
            map.computeIfAbsent(cumulativeSum, x -> new ArrayList<>()).add(i); // Add index to map
        }

        // Display the results
        if (result.isEmpty()) {
            System.out.println("No zero-sum subarray exists");
        } else {
            System.out.println("Zero-sum subarrays are:");
            for (int[] subarray : result) {
                System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the size of the array:");
            int n = scanner.nextInt();
            int[] arr = new int[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            findZeroSumSubarrays(arr);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

/*
Input:
Array size: 5
Array elements: 6 3 -1 -3 4

Output:
Zero-sum subarrays are:
Start: 2, End: 4
 */