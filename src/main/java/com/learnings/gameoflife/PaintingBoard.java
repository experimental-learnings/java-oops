package com.learnings.gameoflife;

import com.learnings.gameoflife.Board.BoardState;

public class PaintingBoard {

	
	public static void paintBoard(BoardState boardState) {
		for (int row = 0; row < boardState.getSize(); row++) {
			for (int col = 0; col < boardState.getSize(); ++col) {
				if(boardState.getToken(new Position(row, col)) !=null ){
					System.out.print(boardState.getToken(new Position(row, col)).getCurrentToken());
				}else{
					System.out.print(boardState.getToken(new Position(row, col)));
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
