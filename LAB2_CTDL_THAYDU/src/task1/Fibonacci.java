package task1;

public class Fibonacci {
	// get the nth value of the Fibonacci series
	public static int getFibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return getFibonacci(n - 1) + getFibonacci(n - 2);
		}
	}

	// This method is used to display a Fibonaccci series based on the parameter n.
	public static void printFibonacci(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Test
		int n = 10;
		System.out.println("Fibonacci series for n=" + n + ":");
		printFibonacci(n);

		int value = 7;
		System.out.println("Fibonacci value for n=" + value + " is: " + getFibonacci(value));
	}
}
