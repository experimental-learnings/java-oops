package com.learnings.gameoflife;

import com.learnings.gameoflife.Board.BoardState;

public class PaintingBoard {

	
	public static void paintBoard(BoardState boardState) {
		for (int row = 0; row < boardState.getSize(); row++) {
			for (int col = 0; col < boardState.getSize(); ++col) {
				if(boardState.getLiveCell(new Position(row, col)) !=null ){
					System.out.print(boardState.getLiveCell(new Position(row, col)));
				}else{
					System.out.print(" ");
				}
				if (col < boardState.getSize() - 1)
					System.out.print("|");
			}
			System.out.println();
			if (row < boardState.getSize() - 1) {
				System.out.println("----------------------------");
			}
		}
		System.out.println("*****************************");
	}
}
