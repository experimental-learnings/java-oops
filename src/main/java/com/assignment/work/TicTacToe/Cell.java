package com.assignment.work.TicTacToe;

public class Cell {
	Seed content;
	int row, col;

	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		emptyCell();
	}

	public void emptyCell() {
		content = Seed.EMPTY;
	}

	public void printCellContent() {
		content.print(System.out);
	}
}
