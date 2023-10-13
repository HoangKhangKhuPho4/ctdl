package task1;

public class BubbleSort {
	public static void bubbleSort(int array[]) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			boolean isSorted = true;
			for (int j = 0; j < n - i - 1; j++) {
				// j j+1 j+1< n-i j<n-i-1
				// nếu phần tử = F thì dãy đã được sắp xếp;
				isSorted = false;
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			printArray(i, array);
			if (isSorted) {
				break;
			}
		}
	}

	public static void printArray(int no, int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 7, 6 };
		bubbleSort(array);
	}
} 
