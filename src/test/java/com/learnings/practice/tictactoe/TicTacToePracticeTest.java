package com.learnings.practice.tictactoe;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.learnings.tictactoe.Position;
import com.learnings.tictactoe.Token;

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
