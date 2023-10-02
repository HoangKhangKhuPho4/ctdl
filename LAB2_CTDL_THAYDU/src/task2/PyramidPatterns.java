package task2;

public class PyramidPatterns {
	public static void drawPyramidPattern1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void drawPyramidPattern2(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void drawPyramidPattern3(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void drawPyramidPattern4(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print(j + " ");
			}
			for (int k = n - i; k >= 1; k--) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}

	public static void drawPyramidPattern5(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int k = i; k <= 2 * i - 1; k++) {
				System.out.print(k + " ");
			}
			for (int l = 2 * i - 2; l >= i; l--) {
				System.out.print(l + " ");
			}
			System.out.println();
		}
	}

	public static void drawInvertedPyramidPattern6(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("  ");
			}
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void drawInvertedPyramidPattern7(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		drawPyramidPattern1(9);
		drawPyramidPattern2(9);
		drawPyramidPattern3(9);
		drawPyramidPattern4(9);
		drawPyramidPattern5(9);
		drawInvertedPyramidPattern6(9);
		drawInvertedPyramidPattern7(9);
	}
}
