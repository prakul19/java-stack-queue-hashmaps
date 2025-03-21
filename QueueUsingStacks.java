import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stackEnqueue = new Stack<>();
    private Stack<Integer> stackDequeue = new Stack<>();

    // Enqueue operation
    public void enqueue(int data) {
        stackEnqueue.push(data);
    }

    // Dequeue operation
    public int dequeue() throws Exception {
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        if (stackDequeue.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return stackDequeue.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of operations:");
            int operations = scanner.nextInt();

            for (int i = 0; i < operations; i++) {
                System.out.println("Enter operation (1 for enqueue, 2 for dequeue):");
                int operation = scanner.nextInt();

                if (operation == 1) {
                    System.out.println("Enter value to enqueue:");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                } else if (operation == 2) {
                    System.out.println("Dequeued value: " + queue.dequeue());
                } else {
                    System.out.println("Invalid operation");
                }
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
5
1
10
1
20
2
2
2

Output:
Dequeued value: 10
Dequeued value: 20
Error: Queue is empty
*/