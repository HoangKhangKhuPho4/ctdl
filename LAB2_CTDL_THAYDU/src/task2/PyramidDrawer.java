package task2;

public class PyramidDrawer {
	public static void drawPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			// Vẽ khoảng trắng (căn giữa)
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}

			// Vẽ dấu 'X'
			for (int k = 1; k <= (2 * i) - 1; k++) {
				System.out.print("X");
			}

			// Xuống dòng
			System.out.println();
		}
	}

	public static void main(String[] args) {
		drawPyramid(4); //
	}
}
