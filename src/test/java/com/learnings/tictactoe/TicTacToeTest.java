package com.learnings.tictactoe;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class TicTacToeTest {

	@Test
	public void shouldAllowPlacementOfTokensOnTheBoard() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);

		Position position = new Position(3, 3);
		Token token = new Token("X");
		board.place(token, position, "player1");

		Position alternatePosition = new Position(5, 5);
		board.place(token, alternatePosition, "player2");

		assertEquals(board.getToken(position), token);
	}

	@Test
	public void shouldNotAllowPlacementInTheSamePosition() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);

		Position position = new Position(3, 3);
		Token token = new Token("X");
		board.place(token, position, "player1");

		Position alternatePosition = new Position(3, 3);

		try {
			board.place(token, alternatePosition, "player2");
		} catch (TokenAlreadyPresentException placementException) {
			return;
		}
		fail("should throw BadPlacementException");
	}

	@Test
	public void shouldNotAllowPlacementBeyondTheBoundaries() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		Position position = new Position(1, 1);
		Token token = new Token("X");
		board.place(token, position, "player1");
		Position alternatePosition = new Position(10, 11);
		try {
			board.place(token, alternatePosition, "player2");
		} catch (OutOfBoardSizeException boundaryException) {
			return;
		}
		fail("should throw OutOfBoadSizeException");

	}

	@Test
	public void shouldNotAllowAPlayerToPlayConsecutiveTurns() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		board.begin();
		Position position = new Position(1, 1);
		Token token = new Token("X");
		board.place(token, position, "player1");

		Position position1 = new Position(1, 2);
		Token token1 = new Token("O");
		try {
			board.place(token1, position1, "player1");
		} catch (WrongPlayerException e) {
		}
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveHorizontalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		board.begin();

		Position position1 = new Position(0, 0);
		Token token1 = new Token("X");

		Position position2 = new Position(1, 0);
		Token token2 = new Token("O");

		Position position3 = new Position(0, 1);
		Token token3 = new Token("X");

		Position position4 = new Position(1, 2);
		Token token4 = new Token("O");

		Position position5 = new Position(0, 2);
		Token token5 = new Token("X");

		board.place(token1, position1, "player1");
		board.place(token2, position2, "player2");
		board.place(token3, position3, "player1");
		board.place(token4, position4, "player2");
		String currState = board.play(token5, position5, "player1");
		assertEquals(currState, "Player1 Won");
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveVerticalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		board.begin();

		Position position1 = new Position(0, 0);
		Token token1 = new Token("X");

		Position position2 = new Position(0, 1);
		Token token2 = new Token("O");

		Position position3 = new Position(1, 2);
		Token token3 = new Token("X");

		Position position4 = new Position(1, 1);
		Token token4 = new Token("O");

		Position position5 = new Position(0, 2);
		Token token5 = new Token("X");

		Position position6 = new Position(2, 1);
		Token token6 = new Token("O");

		board.place(token1, position1, "player1");
		board.place(token2, position2, "player2");
		board.place(token3, position3, "player1");
		board.place(token4, position4, "player2");
		board.place(token5, position5, "player1");
		String currState = board.play(token6, position6, "player2");
		assertEquals(currState, "Player2 Won");
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveRightDiagonalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		board.begin();

		Position position1 = new Position(0, 0);
		Token token1 = new Token("X");

		Position position2 = new Position(0, 1);
		Token token2 = new Token("O");

		Position position3 = new Position(1, 1);
		Token token3 = new Token("X");

		Position position4 = new Position(2, 1);
		Token token4 = new Token("O");

		Position position5 = new Position(2, 2);
		Token token5 = new Token("X");

		board.place(token1, position1, "player1");
		board.place(token2, position2, "player2");
		board.place(token3, position3, "player1");
		board.place(token4, position4, "player2");
		String currState = board.play(token5, position5, "player1");
		assertEquals(currState, "Player1 Won");
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveLeftDiagonalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		board.begin();

		Position position1 = new Position(0, 0);
		Token token1 = new Token("X");

		Position position2 = new Position(0, 2);
		Token token2 = new Token("O");

		Position position3 = new Position(1, 2);
		Token token3 = new Token("X");

		Position position4 = new Position(1, 1);
		Token token4 = new Token("O");

		Position position5 = new Position(2, 2);
		Token token5 = new Token("X");

		Position position6 = new Position(2, 0);
		Token token6 = new Token("O");

		board.place(token1, position1, "player1");
		board.place(token2, position2, "player2");
		board.place(token3, position3, "player1");
		board.place(token4, position4, "player2");
		board.place(token5, position5, "player1");
		String currState = board.play(token6, position6, "player2");
		assertEquals(currState, "Player2 Won");
	}
}
