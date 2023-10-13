package task2;

public class MergeSortDemo {
	public static void mergeSort(int[] array) {
		if (array.length <= 1) {
			return;
		}
		int middle = array.length / 2;
		int[] leftHalfArray = new int[middle];
		int[] rightHalfArray = new int[array.length - middle];

		System.arraycopy(array, 0, leftHalfArray, 0, middle);
		System.arraycopy(array, middle, rightHalfArray, 0, array.length - middle);

		mergeSort(leftHalfArray);
		mergeSort(rightHalfArray);

		merge(array, leftHalfArray, rightHalfArray);
	}

	private static void merge(int[] array, int[] leftHalfArray, int[] rightHalfArray) {
		int i = 0, j = 0, k = 0;

		while (i < leftHalfArray.length && j < rightHalfArray.length) {
			if (leftHalfArray[i] > rightHalfArray[j]) { // Lưu ý: Dùng ">" để sắp xếp giảm dần
				array[k++] = leftHalfArray[i++];
			} else {
				array[k++] = rightHalfArray[j++];
			}
		}

		while (i < leftHalfArray.length) {
			array[k++] = leftHalfArray[i++];
		}

		while (j < rightHalfArray.length) {
			array[k++] = rightHalfArray[j++];
		}
	}

	// Hàm main để test thuật toán
	public static void main(String[] args) {
		int[] array = { 38, 27, 43, 3, 9, 82, 10 };
		System.out.println("Mảng ban đầu:");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();

		mergeSort(array);

		System.out.println("Mảng sau khi sắp xếp:");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
}
