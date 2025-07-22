import java.util.Stack;
public class Queue_Using_Stacks {
    private Stack<Integer> stack1; // For enqueue
    private Stack<Integer> stack2; // For dequeue

    public Queue_Using_Stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation (O(1))
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation (Amortized O(1))
    public int dequeue() {
        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.pop();
    }

    // Peek operation (Amortized O(1))
    public int peek() {
        if (stack2.isEmpty()) {
            // Transfer all elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return stack2.peek();
    }

    // Check if .queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        Queue_Using_Stacks queue = new Queue_Using_Stacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20
        System.out.println(queue.isEmpty()); // false
    }
}
