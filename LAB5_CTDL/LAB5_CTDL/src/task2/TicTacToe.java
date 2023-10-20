package task2;

import java.util.Scanner;

public class TicTacToe {
	private static final char EMPTY = ' ';

	private char[][] board;
	private int n; // size of the board

	public TicTacToe(int n) {
		this.n = n;
		board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	public boolean checkRows() {
		for (int i = 0; i < n; i++) {
			char first = board[i][0];
			if (first == EMPTY)
				continue;

			boolean rowComplete = true;
			for (int j = 1; j < n; j++) {
				if (board[i][j] != first) {
					rowComplete = false;
					break;
				}
			}
			if (rowComplete)
				return true;
		}
		return false;
	}

	public boolean checkColumns() {
		for (int j = 0; j < n; j++) {
			char first = board[0][j];
			if (first == EMPTY)
				continue;

			boolean colComplete = true;
			for (int i = 1; i < n; i++) {
				if (board[i][j] != first) {
					colComplete = false;
					break;
				}
			}
			if (colComplete)
				return true;
		}
		return false;
	}

	public boolean checkDiagonals() {
		char firstMainDiagonal = board[0][0];
		char firstAntiDiagonal = board[n - 1][0];
		boolean mainDiagonalComplete = firstMainDiagonal != EMPTY;
		boolean antiDiagonalComplete = firstAntiDiagonal != EMPTY;

		for (int i = 1; i < n; i++) {
			if (board[i][i] != firstMainDiagonal) {
				mainDiagonalComplete = false;
			}
			if (board[n - 1 - i][i] != firstAntiDiagonal) {
				antiDiagonalComplete = false;
			}
		}

		return mainDiagonalComplete || antiDiagonalComplete;
	}
       // task2.4
	public void printBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j]);
				if (j != n - 1)
					System.out.print(" | ");
			}
			System.out.println();
			if (i != n - 1)
				System.out.println("---------");
		}
	}

	public boolean placeMove(int row, int col, char player) {
		if (board[row][col] == EMPTY) {
			board[row][col] = player;
			return true;
		}
		return false;
	}

	public boolean checkWinner(char player) {
		return checkRows() || checkColumns() || checkDiagonals();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TicTacToe game = new TicTacToe(3);

		char currentPlayer = 'X';
		while (true) {
			game.printBoard();

			System.out.println(
					"Người chơi " + currentPlayer + ", hãy nhập vị trí (dạng hàng cột, ví dụ: 12 cho hàng 1 cột 2):");
			String input = scanner.nextLine();
			if (input.length() != 2 || !Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1))) {
				System.out.println("Vị trí không hợp lệ, hãy thử lại!");
				continue;
			}

			int row = Character.getNumericValue(input.charAt(0)) - 1;
			int col = Character.getNumericValue(input.charAt(1)) - 1;

			if (game.placeMove(row, col, currentPlayer)) {
				if (game.checkWinner(currentPlayer)) {
					game.printBoard();
					System.out.println(currentPlayer + " Wins!");
					break;
				}
				currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			} else {
				System.out.println("Ô này đã được đánh, hãy chọn ô khác!");
			}
		}

		scanner.close();
	}
}
