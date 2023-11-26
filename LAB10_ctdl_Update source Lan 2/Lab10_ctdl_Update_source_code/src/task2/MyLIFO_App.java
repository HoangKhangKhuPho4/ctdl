package task2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyLIFO_App {
	public static <E> void stutter(Queue<E> input) {
        Queue<E> temp = new LinkedList<>();

        for (E element : input) {
            temp.add(element);
            temp.add(element);
        }

        // empty original queue
        input.clear();

        // copy temp queue back to input queue
        for (E element : temp) {
            input.add(element);
        }
    }

    public static <E> void mirror(Queue<E> input) {
        Stack<E> stack = new Stack<>();

        // Add elements to stack to reverse the order
        for (E element : input) {
            stack.push(element);
        }

        // Append reversed elements to the queue
        while (!stack.isEmpty()) {
            input.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        // Test stutter()
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        System.out.println("Queue before stutter: " + queue1);
        MyLIFO_App.stutter(queue1);
        System.out.println("Queue after stutter: " + queue1);

        // Test mirror()
        Queue<String> queue2 = new LinkedList<>();
        queue2.add("a");
        queue2.add("b");
        queue2.add("c");

        System.out.println("Queue before mirror: " + queue2);
        MyLIFO_App.mirror(queue2);
        System.out.println("Queue after mirror: " + queue2);
    }
}