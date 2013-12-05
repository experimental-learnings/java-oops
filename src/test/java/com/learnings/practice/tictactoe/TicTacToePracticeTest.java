package com.learnings.practice.tictactoe;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

import com.learnings.practice.tictactoe.*;
import com.learnings.practice.tictactoe.GameStateChangeListener.GameStateChangeEvent;
import com.learnings.practice.tictactoe.TicTacToeGame.GameState;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;


public class TicTacToePracticeTest {
	
	@Test
	public void shouldBeAbleToPlaceTokenOnBoard(){
		final Integer size = 3;
		Board board = new Board(size);
		Token token = new Token("X");
		Position zeroOne = new Position(0, 1);
		board.place(zeroOne, token);
		assertEquals(board.hasTokenAt(zeroOne), true);
	}

	@Test
	public void shouldNotAllowPlacementInTheSamePosition() {
		final Integer size = 3;
		Board board = new Board(size);
		Token token = new Token("X");
		Position zeroOne = new Position(0, 1);
		board.place(zeroOne, token);
		
		try{
			board.place(zeroOne, token);
		}catch(TokenAlreadyPresentException e){
			return;
		}
		fail("should throw TokenAlreadyPresentException");

	}

	@Test
	public void shouldNotAllowPlacementBeyondTheBoundaries() {
		final Integer size = 3;
		Board board = new Board(size);
		Token token = new Token("X");
		Position zeroFour = new Position(0, 4);
		try{
			board.place(zeroFour, token);
		}catch(OutOFBoundaryException e){
			return;
		}
		fail("should throw OutOFBoundaryException");
	}

	@Test
	public void shouldNotAllowAPlayerToPlayConsecutiveTurns() {
		final Integer size = 3;
		Board board = new Board(size);
		Token firstToken = new Token("X");
		Position zeroOne = new Position(0, 1);
		Position oneTwo = new Position(0, 2);
		board.place(zeroOne, firstToken);
		try{
			board.place(oneTwo, firstToken);
		}catch(WrongPlayerTurnException e){
			return;
		}
		fail("should throw WrongPlayerTurnException");
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveHorizontalPositionsAreFilledBySamePlayer() {
		final Integer size = 3;
		Board board = new Board(3);
		Position zeroZero = new Position(0, 0);
		Position oneZero = new Position(1, 0);
		Position zeroOne = new Position(0, 1);
		Position oneTwo = new Position(1, 2);
		Position zeroTwo = new Position(0, 2);
		Token firstToken = new Token("X");
		Token secondToken = new Token("O");

		TicTacToeGame game = new TicTacToeGame(board);
		
		board.place(zeroZero, firstToken);
		game.getGameStatus(firstToken);
		
		board.place(oneZero, secondToken);
		game.getGameStatus(secondToken);
		
		board.place(zeroOne, firstToken);
		game.getGameStatus(firstToken);
		
		board.place(oneTwo, secondToken);
		game.getGameStatus(secondToken);
		
		GameStateChangeListener gameListener = mock(GameStateChangeListener.class);
		game.setGameStateChangeListener(gameListener);
		
		board.place(zeroTwo, firstToken);
		game.getGameStatus(firstToken);
		
		ArgumentCaptor<GameStateChangeEvent> argument = ArgumentCaptor.forClass(GameStateChangeEvent.class);
		verify(gameListener).onStateChange(argument.capture());
    	assertEquals(argument.getValue().getState(),GameState.PLAYER1);
    	
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveVerticalPositionsAreFilledBySamePlayer() {

	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveRightDiagonalPositionsAreFilledBySamePlayer() {
	}

	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveLeftDiagonalPositionsAreFilledBySamePlayer() {
	
	}
	
}
