package task1;

public class SelectionSort {
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.println("");
	}

	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				// Tìm min[i,n]
				if (array[j] < array[minIndex]) {
					// so sánh bên trái vs bên phải, rồi đổi chổ
					minIndex = j;

				}
			}
			if (minIndex != i) {
				int t = array[i];
				array[i] = array[minIndex];
				array[minIndex] = t;

			}
			printArray(array);

		}
	}
	public static void main(String[] args) {
		 int[] array = {5,3,2,7,8,1,2};
		 selectionSort(array);
		 // với mỗi vòng lặp đưa được số nhỏ nhất lên đầu
	}
}
