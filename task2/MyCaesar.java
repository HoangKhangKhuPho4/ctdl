
package task2;

import java.io.IOException;
import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	public static final char[] DIGIT = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	
	public char encryptChar(char c) {
		
		if (Character.isDigit(c)) {
			for (int index = 0; index < DIGIT.length; index++) {
				if (c == DIGIT[index]) {
					return DIGIT[(index + n) % DIGIT.length];
				}
			}
		}
	
		else {
			for (int index = 0; index < ALPHABET.length; index++) {
			
				if (Character.isUpperCase(c)) {
					if (c == ALPHABET[index]) {
						return ALPHABET[(index + n) % ALPHABET.length];
					}
				}
				
				else {
					if (Character.toUpperCase(c) == ALPHABET[index]) {
						return Character.toLowerCase(ALPHABET[(index + n) % ALPHABET.length]);
					}
				}

			}
		}
		return ' ';
	}

	
	public char decryptChar(char c) {

		if (Character.isDigit(c)) {
			for (int index = 0; index < DIGIT.length; index++) {
				if (c == DIGIT[index]) {
					if (index >= n) {
						return DIGIT[(index - n) % DIGIT.length];
					} else {
						return DIGIT[DIGIT.length - (n - index)];
					}
				}
			}
		}
		
		else {
			for (int index = 0; index < ALPHABET.length; index++) {
			
				if (Character.isUpperCase(c)) {
					if (c == ALPHABET[index]) {
						if (index >= n) {
							return ALPHABET[(index - n) % ALPHABET.length];
						} else {
							return ALPHABET[ALPHABET.length - (n - index)];
						}
					}
				}
				
				else {
					if (Character.toUpperCase(c) == ALPHABET[index]) {
						if (index >= n) {
							return Character.toLowerCase(ALPHABET[(index - n) % ALPHABET.length]);
						} else {
							return Character.toLowerCase(ALPHABET[ALPHABET.length - (n - index)]);
						}
					}
				}

			}
		}

		return ' ';
	}


	public String encrypt(String input) {
		String ketQua = "";
		for (int index = 0; index < input.length(); index++) {
			ketQua += encryptChar(input.charAt(index));
		}
		return ketQua;
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		String ketQua = "";
		for (int index = 0; index < input.length(); index++) {
			ketQua += decryptChar(input.charAt(index));
		}
		return ketQua;  
	}

	// task 4
	public void encryptByUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("type your text to encrypt: ");
		String encryptText = sc.nextLine();
		System.out.println(encrypt(encryptText));
	}

	public void decryptByUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("type your text to decrypt: ");
		String decryptText = sc.nextLine();
		System.out.println(decrypt(decryptText));
	}
     



	public static void main(String[] args) throws IOException {
		MyCaesar myCaesar = new MyCaesar(5);

		System.out.println(myCaesar.encryptChar('z'));
		System.out.println(myCaesar.encryptChar('6'));
		System.out.println(myCaesar.encrypt("Hello, World! 123"));

		System.out.println(myCaesar.decryptChar('U'));
		System.out.println(myCaesar.decryptChar('1'));
		System.out.println(myCaesar.decrypt("N fr Lwtty ns LTYL 6 7 8"));

		// task 4
		myCaesar.encryptByUser();
		myCaesar.decryptByUser();  
		
         
	   

	}
}
