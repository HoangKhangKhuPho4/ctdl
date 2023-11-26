package task1;

import java.util.Arrays;
import java.util.Stack;

public class MyLIFO_App {

	// This method reserves the given array
	public static <E> void reverse(E[] a) {
		Stack<E> buffer = new Stack<>();
		for (int i = 0; i < a.length; i++) {
			buffer.push(a[i]);
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = buffer.pop();
		}
	}

	// This method checks the correctness of the
	// given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>
	// false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty())
					return false;
				char last = stack.peek();
				if ((c == ')' && last == '(') || (c == ']' && last == '[') || (c == '}' && last == '{')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

//		 This method evaluates the value of an
//		expression
//		 i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> numbers = new Stack<>();
		Stack<Character> operators = new Stack<>();

		int length = expression.length();
		for (int i = 0; i < length; i++) {
			char c = expression.charAt(i);

			if (Character.isDigit(c)) {
				int num = c - '0';
				while (i + 1 < length && Character.isDigit(expression.charAt(i + 1))) {
					num = num * 10 + (expression.charAt(i + 1) - '0');
					i++;
				}
				numbers.push(num);
			} else if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				while (operators.peek() != '(') {
					numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
				}
				operators.pop();
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
					numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
				}
				operators.push(c);
			}
		}

		while (!operators.isEmpty()) {
			numbers.push(applyOp(operators.pop(), numbers.pop(), numbers.pop()));
		}

		return numbers.pop();
	}

	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')')
			return false;
		return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
	}

	public static int applyOp(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

	public static void main(String[] args) {

		Integer[] a = { 4, 8, 15, 16, 23, 42 };
		String[] s = { "Jack", "Kate", "Hurley", "Jin", "Michael" };

		System.out.println("a = " + Arrays.toString(a));
		System.out.println("s = " + Arrays.toString(s));

		reverse(a);
		reverse(s);

		System.out.println("After reversing:");
		System.out.println("a = " + Arrays.toString(a));
		System.out.println("s = " + Arrays.toString(s));

		// Test evaluateExpression()
//		String expr3 = "51 + (54 *(3+2))";
//		System.out.println(MyLIFO_App.evaluateExpression(expr3)); // 321

		String[] expressions = { "51 + (54 *(3+2))", "2 + 3 * 4", "(1 + 2) * (3 + 4)" };
		for (String expression : expressions) {
			System.out
					.println("\nThe value of \"" + expression + "\" is: " + MyLIFO_App.evaluateExpression(expression));

		}

		// Test isCorrect method
		String[] validInputs = { "(()){}[]", "{[()()]}", "(){}[]" };
		String[] invalidInputs = { "(]", "([)]", "{(})" };

		for (String input : validInputs) {
			System.out.println("isCorrect(\"" + input + "\") = " + MyLIFO_App.isCorrect(input));
		}

		for (String input : invalidInputs) {
			System.out.println("isCorrect(\"" + input + "\") = " + MyLIFO_App.isCorrect(input));
		}

	}

}
