package task1_And_2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Test {
	public static void main(String[] args) {
		testMyArrayList();
		testMyLinkedList();
	}

	public static void testMyArrayList() {
		MyArrayList<Integer> arrayList = new MyArrayList<>();

		// Add elements
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);

		// Test size
		assert arrayList.size() == 3 : "Error in MyArrayList.size()";

		// Test get
		assert arrayList.get(0) == 1 : "Error in MyArrayList.get()";

		// Test set
		arrayList.set(0, 5);
		assert arrayList.get(0) == 5 : "Error in MyArrayList.set()";

		// Test remove
		arrayList.remove(1);
		assert arrayList.size() == 2 : "Error in MyArrayList.remove()";

		// Test lastIndexOf
		assert arrayList.lastIndexOf(5) == 0 : "Error in MyArrayList.lastIndexOf()";

		// Test toArray
		Object[] array = arrayList.toArray();
		assert Arrays.equals(array, new Object[] { 5, 3 }) : "Error in MyArrayList.toArray()";

		// Test clone
		MyArrayList<Integer> clonedList = (MyArrayList<Integer>) arrayList.clone();
		assert clonedList.size() == arrayList.size() : "Error in MyArrayList.clone() - size mismatch";
		for (int i = 0; i < arrayList.size(); i++) {
			assert clonedList.get(i).equals(arrayList.get(i))
					: "Error in MyArrayList.clone() - content mismatch at index " + i;
		}

		// Test contains
		assert !arrayList.contains(2) : "Error in MyArrayList.contains()";
		assert arrayList.indexOf(3) == 1 : "Error in MyArrayList.indexOf()";

		// Test sort
		arrayList.add(2); // Adding back the removed value for a meaningful sort test
		arrayList.sort(Integer::compare);
		assert arrayList.get(0) == 2 : "Error in MyArrayList.sort()";
		assert arrayList.get(1) == 3 : "Error in MyArrayList.sort()";
		assert arrayList.get(2) == 5 : "Error in MyArrayList.sort()";

		// Edge cases
		try {
			arrayList.get(-1);
			assert false : "Expected IndexOutOfBoundsException for MyArrayList.get() with negative index";
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			arrayList.get(arrayList.size());
			assert false : "Expected IndexOutOfBoundsException for MyArrayList.get() with index >= size()";
		} catch (IndexOutOfBoundsException e) {
		}

		System.out.println("MyArrayList tests passed successfully!");
	}

	public static void testMyLinkedList() {
		MyLinkedList<String> linkedList = new MyLinkedList<>();

		// Add elements
		linkedList.addFirst("a");
		linkedList.addLast("b");
		linkedList.addLast("c");

		// Test size
		assert linkedList.size() == 3 : "Error in MyLinkedList.size()";

		// Test get first/last
		assert linkedList.first().equals("a") : "Error in MyLinkedList.first()";
		assert linkedList.last().equals("c") : "Error in MyLinkedList.last()";

		// Test remove
		linkedList.removeFirst();
		linkedList.removeLast();
		assert linkedList.size() == 1 : "Error in MyLinkedList.remove()";

		// Edge cases
		try {
			linkedList.removeFirst();
			linkedList.removeFirst(); // this should throw an exception since the list is now empty
			assert false : "Expected NoSuchElementException for MyLinkedList.removeFirst() on empty list";
		} catch (NoSuchElementException e) {
		}

		System.out.println("MyLinkedList tests passed successfully!");
	}
}
