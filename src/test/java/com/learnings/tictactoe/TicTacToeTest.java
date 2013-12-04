package com.learnings.tictactoe;

import static org.testng.Assert.*;

import static org.mockito.Mockito.*;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import com.learnings.tictactoe.BoardStateChangeListener.BoardStateChangeEvent;
import com.learnings.tictactoe.GameStateChangeListener.GameStateChangeEvent;
import com.learnings.tictactoe.TicTacToeBoard.BoardState;
import com.learnings.tictactoe.TicTacToeGame.GameState;
import com.learnings.tictactoe.exceptions.OutOfBoardSizeException;
import com.learnings.tictactoe.exceptions.TokenAlreadyPresentException;
import com.learnings.tictactoe.exceptions.WrongPlayerException;

public class TicTacToeTest {
	@Test
	public void shouldAllowPlacementOfTokensOnTheBoard() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		final boolean[] status = new boolean[1];
		final Position position = new Position(3, 3);
		final Token token = new Token("X");

		board.setBoardStateChangeListener(new BoardStateChangeListener(){

			@Override
			public void onStateChange(BoardStateChangeEvent event) {
				BoardState boardState = event.getState();
				assertTrue(boardState.hasTokenAt(position));
				assertEquals(boardState.getToken(position), token);
				status[0] = true;
			}
		});

		board.place(token, position);
		
		assertTrue(status[0]);
		assertEquals(board.getToken(position), token);
	}
	
	@Test
	public void shouldAllowPlacementOfTokensOnTheBoardAnotherWay() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		final Position position = new Position(3, 3);
		Token token = new Token("X");
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);
		board.place(token, position);

		ArgumentCaptor<BoardStateChangeEvent> argument = ArgumentCaptor.forClass(BoardStateChangeEvent.class);
		verify(listener).onStateChange(argument.capture());
    	assertTrue(argument.getValue().getState().hasTokenAt(position));
	}

	@Test
	public void shouldNotAllowPlacementInTheSamePosition() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		
		Position threeThree = new Position(3, 3);
		Position anotherThreeThree = new Position(3, 3);

		Token tokenX = new Token("X");
		Token tokenZero = new Token("0");
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);
		board.place(tokenX, anotherThreeThree);

		try {
			board.place(tokenZero, threeThree);
		} catch (TokenAlreadyPresentException placementException) {
			return;
		}
		fail("should throw BadPlacementException");
	}

	@Test
	public void shouldNotAllowPlacementBeyondTheBoundaries() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		Position elevenEleven = new Position(11, 11);
		Token token = new Token("X");
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);
		
		try {
			board.place(token, elevenEleven);
		} catch (OutOfBoardSizeException boundaryException) {
			return;
		}
		fail("should throw OutOfBoadSizeException");

	}

	@Test
	public void shouldNotAllowAPlayerToPlayConsecutiveTurns() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		Position position = new Position(1, 1);
		Position position1 = new Position(1, 2);
		Token token = new Token("O");
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);

		board.place(token, position);

		try {
			board.place(token, position1);
		} catch (WrongPlayerException e) {
			return;
		}
		fail("should throw Wrong player exception");
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveHorizontalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		Position position1 = new Position(0, 0);
		Position position2 = new Position(1, 0);
		Position position3 = new Position(0, 1);
		Position position4 = new Position(1, 2);
		Position position5 = new Position(0, 2);
		Token firstToken = new Token("X");
		Token secondToken = new Token("O");

		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);

		TicTacToeGame game = new TicTacToeGame(board);
		
		board.place(firstToken, position1);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, position2);
		game.getGameStatus(secondToken);
		
		board.place(firstToken, position3);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, position4);
		game.getGameStatus(secondToken);
		
		GameStateChangeListener gameListener = mock(GameStateChangeListener.class);
		game.setGameStateChangeListener(gameListener);
		
		board.place(firstToken, position5);
		game.getGameStatus(firstToken);
		
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
    	assertEquals(argument.getValue().getState(),GameState.PLAYER1);
    	
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveVerticalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		Position zeroZero = new Position(0, 0);
		Position zeroOne = new Position(0, 1);
		Position position3 = new Position(1, 2);
		Position position4 = new Position(1, 1);
		Position position5 = new Position(0, 2);
		Position position6 = new Position(2, 1);
		Token firstToken = new Token("X");
		Token secondToken = new Token("O");

		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);

		TicTacToeGame game = new TicTacToeGame(board);

		board.place(firstToken, zeroZero);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, zeroOne);
		game.getGameStatus(secondToken);
		
		board.place(firstToken, position3);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, position4);
		game.getGameStatus(secondToken);
		
		board.place(firstToken, position5);
		game.getGameStatus(firstToken);
		
		GameStateChangeListener gameListener = mock(GameStateChangeListener.class);
		game.setGameStateChangeListener(gameListener);
		
		board.place(secondToken, position6);
		game.getGameStatus(secondToken);
		
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
    	assertEquals(argument.getValue().getState(),GameState.PLAYER2);
    	
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveRightDiagonalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		Position position1 = new Position(0, 0);
		Position position2 = new Position(0, 1);
		Position position3 = new Position(1, 1);
		Position position4 = new Position(2, 1);
		Position position5 = new Position(2, 2);
		Token firstToken = new Token("X");
		Token secondToken = new Token("O");
		
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);

		TicTacToeGame game = new TicTacToeGame(board);

		board.place(firstToken, position1);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, position2);
		game.getGameStatus(secondToken);
		
		board.place(firstToken, position3);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, position4);
		game.getGameStatus(secondToken);
		
		GameStateChangeListener gameListener = mock(GameStateChangeListener.class);
		game.setGameStateChangeListener(gameListener);
		
		board.place(firstToken, position5);
		game.getGameStatus(firstToken);
		
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
    	assertEquals(argument.getValue().getState(),GameState.PLAYER1);
	
	
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveLeftDiagonalPositionsAreFilledBySamePlayer() {
		final Integer rows = 3;
		TicTacToeBoard board = new TicTacToeBoard(rows, 3);
		Position position1 = new Position(0, 0);
		Position position2 = new Position(0, 2);
		Position position3 = new Position(1, 2);
		Position position4 = new Position(1, 1);
		Position position5 = new Position(2, 2);
		Position position6 = new Position(2, 0);
		Token firstToken = new Token("X");
		Token secondToken = new Token("O");
		
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);

		TicTacToeGame game = new TicTacToeGame(board);


		board.place(firstToken, position1);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, position2);
		game.getGameStatus(secondToken);
		
		board.place(firstToken, position3);
		game.getGameStatus(firstToken);
		
		board.place(secondToken, position4);
		game.getGameStatus(secondToken);
		
		board.place(firstToken, position5);
		game.getGameStatus(firstToken);
		
		GameStateChangeListener gameListener = mock(GameStateChangeListener.class);
		game.setGameStateChangeListener(gameListener);
		
		board.place(secondToken, position6);
		game.getGameStatus(secondToken);
		
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
    	assertEquals(argument.getValue().getState(),GameState.PLAYER2);

	}
}
