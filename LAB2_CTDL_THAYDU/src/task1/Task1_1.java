package task1;

public class Task1_1 {
	// S(n) = 1 - 2 + 3 - 4 + … + ((-1)^(n+1)).n , n>0
	public static int getSn1(int n) {
		if (n == 1)
			return 1;
		return ((-1) ^ (n + 1) * n) + getSn1(n - 1);
	}

	// S(n) = 1 + 1.2 + 1.2.3 + … + 1.2.3…n, n>0
	public static int getSn2(int n) {
		if (n == 1)
			return 1;
		return factorial(n) + getSn2(n - 1);
	}

	private static int factorial(int n) {
		if (n == 1)
			return 1;
		return n * factorial(n - 1);
	}

	// S(n) = 1^2 + 2^2 + 3^2 + .... + n^2 , n>0
	public static int getSn3(int n) {
		if (n == 1)
			return 1;
		return (n * n) + getSn3(n - 1);
	}

	// S(n) = 1 + 1/2 + 1/(2.4) + 1/(2.4.6) + … + 1/(2.4.6...2n)
	public static double getSn4(int n) {
		if (n == 0)
			return 1.0;
		return (1.0 / doubleFactorial(2 * n)) + getSn4(n - 1);
	}

	private static double doubleFactorial(int n) {
		if (n <= 1)
			return 1.0;
		return n * doubleFactorial(n - 2);
	}

	public static void testGetSn1() {
		System.out.println("Testing getSn1 method:");
		int[] testCases = { 1, 2, 5, 10, 20, 50 };
		for (int testCase : testCases) {
			System.out.println("getSn1(" + testCase + ") = " + Task1_1.getSn1(testCase));
		}
		System.out.println("------------------------------");
	}

	public static void testGetSn2() {
		System.out.println("Testing getSn2 method:");
		int[] testCases = { 1, 2, 5, 10, 15, 20 };
		for (int testCase : testCases) {
			System.out.println("getSn2(" + testCase + ") = " + Task1_1.getSn2(testCase));
		}
		System.out.println("------------------------------");
	}

	public static void testGetSn3() {
		System.out.println("Testing getSn3 method:");
		int[] testCases = { 1, 2, 5, 10, 20, 30, 50 };
		for (int testCase : testCases) {
			System.out.println("getSn3(" + testCase + ") = " + Task1_1.getSn3(testCase));
		}
		System.out.println("------------------------------");
	}

	public static void testGetSn4() {
		System.out.println("Testing getSn4 method:");
		int[] testCases = { 0, 1, 2, 5, 10, 15 };
		for (int testCase : testCases) {
			System.out.println("getSn4(" + testCase + ") = " + Task1_1.getSn4(testCase));
		}
		System.out.println("------------------------------");
	}

	public static void main(String[] args) {
		// Test for getSn1 method
		testGetSn1();

		// Test for getSn2 method
		testGetSn2();

		// Test for getSn3 method
		testGetSn3();

		// Test for getSn4 method
		testGetSn4();
	}
}
