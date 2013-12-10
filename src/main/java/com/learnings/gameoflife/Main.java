package com.learnings.gameoflife;


public class Main {

	public static void main(String str[]){
		Token deadCell = new Token("D");
		Token aliveCell = new Token("L");
		final Integer size = 3;
		final Integer noOfGenerations = 3;
		Position zeroZero = new Position(0, 0);
		Position zeroOne = new Position(0, 1);
		Position zeroTwo = new Position(0, 2);
		Position oneZero = new Position(1, 0);
		Position oneOne = new Position(1, 1);
		Position oneTwo = new Position(1, 2);
		Position twoZero = new Position(2, 0);
		Position twoOne = new Position(2, 1);
		Position twoTwo = new Position(2, 2);
		Position[] positions = {zeroZero,zeroOne,zeroTwo,oneZero,oneOne,oneTwo,twoZero,twoOne,twoTwo};
		Token []tokens = {deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell};
		Board board = new Board(size, noOfGenerations);
		
		//BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(new BoardListener());
		board.generateFirstGenerationPattern(positions, tokens);
		
	}
}
