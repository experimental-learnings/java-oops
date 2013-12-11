package com.learnings.gameoflife;
import java.io.Console;



public class Main {

	public static void main(String str[]){
		ShouldBeAbleToPlaceALiveCellOnTheBoard();
	}
	public static void ShouldBeAbleToPlaceALiveCellOnTheBoard() {
		String liveCell = "L";
		final Integer size = 3;
		Position zeroOne = new Position(0, 1);
		Board board = new Board(size);
		Console cons = System.console();
		board.place(zeroOne, liveCell);
		PaintingBoard.paintBoard(board.getBoardState());

	}

}
