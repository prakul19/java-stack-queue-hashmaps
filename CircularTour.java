import java.util.*;

public class CircularTour {

    // Method to find the starting petrol pump for completing the circular tour
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalPetrol = 0, totalDistance = 0, start = 0, surplus = 0;
        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            surplus += petrol[i] - distance[i];

            // If surplus becomes negative, move the starting point
            if (surplus < 0) {
                start = i + 1; // Shift starting point
                surplus = 0;   // Reset surplus
            }
        }
        // If total petrol is less than total distance, tour is impossible
        return (totalPetrol >= totalDistance) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter number of petrol pumps:");
            int n = scanner.nextInt();
            int[] petrol = new int[n];
            int[] distance = new int[n];

            System.out.println("Enter petrol available at each pump:");
            for (int i = 0; i < n; i++) {
                petrol[i] = scanner.nextInt();
            }

            System.out.println("Enter distance to the next pump:");
            for (int i = 0; i < n; i++) {
                distance[i] = scanner.nextInt();
            }

            int result = findStartingPoint(petrol, distance);

            if (result == -1) {
                System.out.println("Circular tour is not possible");
            } else {
                System.out.println("Start at petrol pump: " + result);
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
Number of petrol pumps: 4
Petrol available: 4 6 7 4
Distance to next pump: 6 5 3 5

Output:
Start at petrol pump: 1
 */