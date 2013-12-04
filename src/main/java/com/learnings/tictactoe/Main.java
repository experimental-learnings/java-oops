package com.learnings.tictactoe;

public class Main {

	public static void main(final String[] str) {
		TicTacToeBoard board = new TicTacToeBoard(3,3);
		TicTacToeGame game = new TicTacToeGame(board);
		Token firstToken = new Token("X");
		Token secondToken = new Token("O");
		Position zeroZero = new Position(0, 0);
		Position zeroOne = new Position(0, 1);
		Position zeroTwo = new Position(0, 2);
		Position oneZero = new Position(1, 0);
		Position oneOne = new Position(1, 1);
		Position oneTwo = new Position(2, 2);
		Position twoZero= new Position(2, 0);
		Position twoOne = new Position(1, 1);
		Position twoTwo = new Position(2, 2);
		
		board.setBoardStateChangeListener(new BoardListener());
		game.setGameStateChangeListener(new GameListener());
		
		board.place(firstToken, zeroZero);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, zeroOne);
		game.getGameStatus(firstToken);
		
		board.place(firstToken, oneOne);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, zeroTwo);
		game.getGameStatus(firstToken);
		
		board.place(firstToken, twoTwo);
		game.getGameStatus(firstToken);


	}
}
