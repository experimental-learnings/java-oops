package com.assignment.work.TicTacToe;

public class Board {
	private int ROWS;
	private int SIZE;
	private int COLS;
	Cell[][] cells;
	int currentRow, currentCol;

	public Board(int size) {
		this.SIZE = size;
		this.ROWS = size;
		this.COLS = size;
		cells = new Cell[size][size];
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}

	public void clear() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col].emptyCell();
			}
		}
	}

	public boolean isDraw() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (cells[row][col].content == Seed.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean checkRows(Seed theSeed) {
		int count = 0;
		for (int i = 0; i < SIZE; i++) {
			if (cells[currentRow][i].content == theSeed) {
				count = count + 1;
			}
		}
		return count == SIZE;
	}

	public boolean checkCols(Seed theSeed) {
		int count = 0;
		for (int i = 0; i < SIZE; i++) {
			if (cells[i][currentCol].content == theSeed) {
				count = count + 1;
			}
		}
		return count == SIZE;
	}

	public boolean checkDiagonals(Seed theSeed) {
		int count = 0;
		int count1 = 0;
		if (currentRow == currentCol) {
			for (int i = 0; i < SIZE; i++) {
				if (cells[i][i].content == theSeed) {
					count = count + 1;
				}
			}
			return count == SIZE;
		} else if (currentRow + currentCol == SIZE - 1) {
			for (int i = 0; i < SIZE; i++) {
				if (cells[i][SIZE - i - 1].content == theSeed) {
					count1 = count1 + 1;
				}
			}
			return count1 == SIZE;
		}
		return count == SIZE;
	}

	public boolean hasWon(Seed theSeed) {
		return (checkRows(theSeed) || checkCols(theSeed) || checkDiagonals(theSeed));
	}

	public void paintBoard() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col].printCellContent();
				if (col < COLS - 1)
					System.out.print("|");
			}
			System.out.println();
			if (row < ROWS - 1) {
				System.out.println("----------------------------");
			}
		}
	}

	public boolean move(int row, int col, Seed theSeed) {
		if (row >= 0 && row < ROWS && col >= 0 && col < COLS
				&& cells[row][col].content == Seed.EMPTY) {
			cells[row][col].content = theSeed;
			currentRow = row;
			currentCol = col;
			return true;
		} else {
			System.out.println("This move at is not valid. Try again...");
			return false;
		}
	}

}
