package task2;

import java.util.LinkedList;
import java.util.Queue;

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
		Queue<E> temp = new LinkedList<>();

		// add elements to temp queue
		for (E element : input) {
			temp.add(element);
		}

		// traverse input queue in reverse and add to temp queue
		for (int i = input.size() - 1; i >= 0; i--) {
			E element = input.poll();
			temp.add(element);
		}

		// empty original queue
		input.clear();

		// copy elements back from temp queue
		for (E element : temp) {
			input.add(element);
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
