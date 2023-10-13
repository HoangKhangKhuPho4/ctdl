package task2;

import java.util.Random;

public class QuickSortDemo {
	public static void quickSort(int[] array) {
		quickSortHelper(array, 0, array.length - 1, "median");
	}

	private static void quickSortHelper(int[] array, int low, int high, String method) {
		if (low < high) {
			int pivot = partition(array, low, high, method);
			quickSortHelper(array, low, pivot - 1, method);
			quickSortHelper(array, pivot + 1, high, method);
		}
	}

	private static int partition(int[] array, int low, int high, String method) {
		int pivot;
		switch (method) {
		case "first":
			pivot = getPivot_First(array, low);
			break;
		case "last":
			pivot = getPivot_Last(array, high);
			break;
		case "random":
			pivot = getPivot_Random(array, low, high);
			break;
		default:
			pivot = getPivot_MedianOfThree(array, low, high);
		}

		int temp = array[pivot];
		array[pivot] = array[high];
		array[high] = temp;

		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j] < array[high]) {
				i++;
				int swap = array[i];
				array[i] = array[j];
				array[j] = swap;
			}
		}

		temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		return i + 1;
	}

	private static int getPivot_MedianOfThree(int[] array, int low, int high) {
		int mid = low + (high - low) / 2;
		if (array[low] > array[mid])
			swap(array, low, mid);
		if (array[low] > array[high])
			swap(array, low, high);
		if (array[mid] > array[high])
			swap(array, mid, high);
		return mid;
	}

	private static int getPivot_First(int[] array, int low) {
		return low;
	}

	private static int getPivot_Last(int[] array, int high) {
		return high;
	}

	private static int getPivot_Random(int[] array, int low, int high) {
		Random rand = new Random();
		return low + rand.nextInt(high - low + 1);
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 80, 30, 90, 40, 50, 70 };
		System.out.print("Original Array: ");
		for (int value : arr) {
			System.out.print(value + " ");
		}
		System.out.println();

		quickSort(arr);

		System.out.print("Sorted Array: ");
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}
}
