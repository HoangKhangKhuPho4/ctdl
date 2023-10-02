package task1;

public class PascalTriangle {
	// This method is used to display a Pascal triangle based on the parameter n.
	// Where n represents the number of rows

	public static void printPascalTriangle(int row) {
		int width = row * 2;
		for (int i = 1; i <= row; i++) {
			int[] currentRow = getPascalTriangle(i);
			// Căn giữa cho mỗi dòng
			int padding = (width - i) / 2;
			for (int p = 0; p < padding; p++) {
				System.out.print(" ");
			}
			for (int j = 0; j < currentRow.length; j++) {
				System.out.print(currentRow[j] + " ");
			}
			System.out.println();
		}
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n == 1)
			return new int[] { 1 };
		int[] prevRow = getPascalTriangle(n - 1);
		return generateNextRow(prevRow);
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		nextRow[0] = 1;
		nextRow[nextRow.length - 1] = 1;
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	public static void main(String[] args) {
		printPascalTriangle(5); // Điều này sẽ in ra 5 dòng đầu tiên của tam giác Pascal
	}
}
