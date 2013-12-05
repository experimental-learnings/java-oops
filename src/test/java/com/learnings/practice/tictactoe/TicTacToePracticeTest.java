package com.learnings.practice.tictactoe;

import static org.testng.Assert.assertEquals;
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

	}

	@Test
	public void shouldNotAllowPlacementBeyondTheBoundaries() {

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