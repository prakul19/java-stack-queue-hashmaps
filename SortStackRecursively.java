import java.util.Stack;

public class SortStackRecursively {

    // Method to sort a stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);     // Sort remaining stack recursively
            insertInSortedOrder(stack, top); // Insert top element in sorted order
        }
    }

    // Helper method to insert an element in a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element); // Push element if stack is empty or top is smaller
        } else {
            int top = stack.pop();
            insertInSortedOrder(stack, element); // Recursive call
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
/*
Input:
Stack: [3, 1, 4, 2]

Output:
Original Stack: [3, 1, 4, 2]
Sorted Stack: [1, 2, 3, 4]
*/