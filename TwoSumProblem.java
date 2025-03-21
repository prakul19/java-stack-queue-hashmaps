import java.util.HashMap;
import java.util.Scanner;

public class TwoSumProblem {

    // Method to find two indices such that their values add up to the target
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Map to store value and its index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // Calculate complement
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return indices if complement is found
            }
            map.put(nums[i], i); // Store the current number with its index
        }
        return new int[]{-1, -1}; // Return [-1, -1] if no pair is found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the size of the array:");
            int n = scanner.nextInt();
            int[] nums = new int[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.println("Enter the target sum:");
            int target = scanner.nextInt();

            int[] result = twoSum(nums, target);

            if (result[0] != -1) {
                System.out.println("Indices: " + result[0] + ", " + result[1]);
            } else {
                System.out.println("No pair found with the given target sum.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

/*
Input:
Array size: 4
Array elements: 2 7 11 15
Target sum: 9

Output:
Indices: 0, 1
 */