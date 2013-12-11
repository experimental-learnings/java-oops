package com.learnings.gameoflife;
import static org.testng.Assert.assertEquals;

import java.io.Console;



public class Main {

	public static void main(String str[]){
		ShouldBeAbleToPlaceALiveCellOnTheBoard();
		//shouldInitializeBoardWithFirstGeneration();
	}
	public static void shouldInitializeBoardWithFirstGeneration() {
		String liveCell = "L";
		final Integer size = 3;
		Position zeroOne = new Position(0, 1);
		Position oneOne = new Position(1, 1);
		Position twoOne = new Position(2, 1);
		Board board = new Board(size);
		
		//board.place(zeroOne, liveCell);
		//board.place(oneOne, liveCell);
		//board.place(twoOne, liveCell);
		PaintingBoard.paintBoard(board.getBoardState());
		
	}

	public static void ShouldBeAbleToPlaceALiveCellOnTheBoard() {
		String liveCell = "L";
		final Integer size = 3;
		Position zeroOne = new Position(1, 1);
		Board board = new Board(size);
		Console cons = System.console();
		board.place(zeroOne, liveCell);
		PaintingBoard.paintBoard(board.getBoardState());

	}

}
