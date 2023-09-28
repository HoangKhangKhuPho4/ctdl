package task1;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int[] mirrorArray = new int[this.array.length * 2];

		for (int index = 0; index < this.array.length; index++) {
			mirrorArray[index] = array[index];
			mirrorArray[mirrorArray.length - 1 - index] = array[index];
		}
		return mirrorArray;
	}

	public int[] removeDuplicates() {
		int dem = 0;
		boolean isNotDuplicate;
		int[] removeDupArray = new int[this.array.length];

		for (int index = 0; index < removeDupArray.length; index++) {
			isNotDuplicate = true;
			for (int j = 0; j < dem; j++) {
				if (removeDupArray[j] == this.array[index]) {
					isNotDuplicate = false;
					break;
				}
			}
			if (isNotDuplicate) {
				removeDupArray[dem] = this.array[index];
				dem++;
			}
		}

		int[] ketQua = new int[dem];
		for (int index = 0; index < ketQua.length; index++) {
			ketQua[index] = removeDupArray[index];
		}

		return ketQua;
	}

	public int[] getMissingValues() {
		int dem = 0;
		int[] ketQua;
		int[] array = this.array.clone();

		for (int index = 0; index < array.length - 1; index++) {
			if (array[index + 1] == array[index] + 1) {
				dem++;
			}
		}
		ketQua = new int[array.length - dem - 1];

		for (int index = 0; index < array.length - dem - 1; index++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j + 1] != array[j] + 1) {
					ketQua[index] = array[j] + 1;
					index++;
				}
			}
		}

		return ketQua;
	}

	public int[] fillMissingValues(int k) {
		int[] ketQua = array.clone();
		for (int i = 0; i < ketQua.length - 1; i++) {
			if (array[i] > ketQua[i + 1]) {
				ketQua[i + 1] = (ketQua[i] + ketQua[i + 2] + ketQua[i + 3]) / k;
			}
		}

		return ketQua;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[] arr2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		int[] arr3 = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		int[] arr4 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };


		MyArray myArray = new MyArray(arr);
		MyArray myArray2 = new MyArray(arr2);
		MyArray myArray3 = new MyArray(arr3);
		MyArray myArray4 = new MyArray(arr4);

		System.out.println(Arrays.toString(myArray.mirror()));
		System.out.println(Arrays.toString(myArray2.removeDuplicates()));
		System.out.println(Arrays.toString(myArray3.getMissingValues()));
		System.out.println(Arrays.toString(myArray4.fillMissingValues(3)));

	}

}
