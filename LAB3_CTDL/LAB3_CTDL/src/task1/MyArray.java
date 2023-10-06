package task1;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// Iterative Linear Search
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

	// Recursive Linear Search
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchHelper(target, 0);
	}

	private int recursiveLinearSearchHelper(int target, int index) {
		if (index >= array.length) {
			return -1;
		}
		if (array[index] == target) {
			return index;
		}
		return recursiveLinearSearchHelper(target, index + 1);
	}

	// Iterative Binary Search for Descending Order
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	// Recursive Binary Search for Descending Order
	public int recursiveBinarySearch(int target) {
		return recursiveBinarySearchHelper(target, 0, array.length - 1);
	}

	private int recursiveBinarySearchHelper(int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (array[mid] == target) {
			return mid;
		} else if (array[mid] > target) {
			return recursiveBinarySearchHelper(target, mid + 1, high);
		} else {
			return recursiveBinarySearchHelper(target, low, mid - 1);
		}
	}

	public static void main(String[] args) {
		int[] sampleArray = { 45, 10, 2, 45, 9, 10, 12 }; // Mảng đã sắp xếp theo thứ tự giảm dần

		MyArray myArray = new MyArray(sampleArray);

		// Testing for Task 1.1
		System.out.println("Testing for Task 1.1");
		System.out.println("Iterative Linear Search for 45: " + myArray.iterativeLinearSearch(45)); // Expected: 0 (vì
																									// 45 xuất hiện lần
																									// đầu tiên ở vị trí
																									// 0)
		System.out.println("Recursive Linear Search for 15: " + myArray.recursiveLinearSearch(15)); // Expected: -1 (vì
																									// 15 không xuất
																									// hiện trong mảng)

		// Testing for Task 1.2
		System.out.println("\nTesting for Task 1.2");
		System.out.println("Iterative Binary Search for 45: " + myArray.iterativeBinarySearch(45)); // Expected: A valid
																									// index (có thể là
																									// 0 hoặc 3 vì 45
																									// xuất hiện 2 lần)
		System.out.println("Recursive Binary Search for 15: " + myArray.recursiveBinarySearch(15)); // Expected: -1

		// Testing for Task 1.3
		System.out.println("\nTesting for Task 1.3 (Array in Descending Order)");
		System.out.println("Iterative Binary Search for 45: " + myArray.iterativeBinarySearch(45));
		System.out.println("Recursive Binary Search for 12: " + myArray.recursiveBinarySearch(12)); // Expected: 6 (vì
																									// 12 nằm ở cuối
																									// mảng)
		System.out.println("Recursive Binary Search for 15: " + myArray.recursiveBinarySearch(15)); // Expected: -1
	}
}
