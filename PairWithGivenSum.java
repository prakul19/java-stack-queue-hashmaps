import java.util.*;

public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seenNumbers = new HashSet<>(); // To track visited numbers
        for (int num : arr) {
            // Calculate complement
            int complement = target - num;
            if (seenNumbers.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }
            seenNumbers.add(num);
        }
        System.out.println("No pair with the given sum exists.");
        return false;
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
            System.out.println("Enter the target sum:");
            int target = scanner.nextInt();
            // Check for pair with given sum
            hasPairWithSum(arr, target);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Handle exceptions
        } finally {
            scanner.close();
        }
    }
}

/*
Input:
Array size: 6
Array elements: 1 4 6 8 3 7
Target sum: 10

Output:
Pair found: (6, 4)
 */