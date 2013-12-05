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
		Position position = new Position(0, 1);
		board.place(position, token);
		assertEquals(board.hasTokenAt(position), true);
	}

	@Test
	public void shouldNotAllowPlacementInTheSamePosition() {
		final Integer size = 3;
		Board board = new Board(size);
		Token token = new Token("X");
		Position position = new Position(0, 1);
		board.place(position, token);
		
		try{
			board.place(position, token);
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
		Position position = new Position(0, 4);
		try{
			board.place(position, token);
		}catch(OutOFBoundaryException e){
			return;
		}
		fail("should throw OutOFBoundaryException");
	}

	@Test
	public void shouldNotAllowAPlayerToPlayConsecutiveTurns() {
		
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
