import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

    // Method to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while the stack is not empty
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            // Calculate span
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter number of days:");
            int n = scanner.nextInt();
            int[] prices = new int[n];

            System.out.println("Enter stock prices:");
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            int[] span = calculateSpan(prices);

            System.out.println("Stock spans:");
            for (int s : span) {
                System.out.print(s + " ");
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
Enter number of days:
6
Enter stock prices:
100 80 60 70 60 75 85

Output:
Stock spans:
1 1 1 2 1 4 6
 */