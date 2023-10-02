package task2;

public class ChristmasTree {
	public static void drawChristmasTree(int n) {
		for (int i = 1; i <= n; i++) {
			drawPart(i, n);
		}
	}

	public static void drawPart(int height, int maxParts) {
		int maxWidth = maxParts * 2 - 1; // Tính chiều rộng tối đa dựa trên chiều cao tối đa
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= maxWidth; j++) {
				if (j <= maxWidth / 2 + i && j >= maxWidth / 2 - i + 2) {
					System.out.print("X");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		drawChristmasTree(4);
	}
}
