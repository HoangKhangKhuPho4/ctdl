package task1;

public class InsertionSort {
	public static void printArray(int no,int[]array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.println();
	}
    public static void insertionSort(int[]array) {
   	 int n = array.length;
   	 for (int i = 1; i < array.length; i++) {
			// chèn a[i] vào dãy 0->1
   		 int ai = array[i];
   		 int j = i-1;
   		while (j>=0 && array[j]> ai) {
				array[j+1] = array[j]; // tiến j lên 1 đơn vị để xét tiếp phần tử tiếp theo
				j--;
			}
   		array[j+1] = ai;
   		 printArray(j, array);
		}
    }
    public static void main(String[] args) {
		int[]array = {5,3,2,7,8,1,2};
		insertionSort(array);
		
	}
}
