package com.assignment.work;

public final class PrintBoard {
	private static final int ROWS = 3;
	private static final int COLS = 3;
	private static final int EMPTY = 0;
	private static final int BigO = 1;
	private static final int CROSS = 2;
	private static int[][] boardArray = new int[ROWS][COLS];

	private PrintBoard() {
	}

	public static void main(String str[]) {
		// do{
		// initStartGame();
		printBoard();
		// }while(true);

	}

	public static void printBoard() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				printContent(boardArray[row][col]);
				if (col < COLS - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (row < ROWS - 1) {
				System.out.println("-----------");
			}
		}
		System.out.println();
	}

	public static void printContent(int content) {
		switch (content) {
		case BigO:
			System.out.print(" O ");
			break;
		case CROSS:
			System.out.print(" X ");
			break;
		case EMPTY:
			System.out.print("   ");
			break;
		}
	}
}
