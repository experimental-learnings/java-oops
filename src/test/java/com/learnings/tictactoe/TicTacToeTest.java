package com.learnings.tictactoe;

import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class TicTacToeTest {
	

	@Test
	public void shouldAllowPlacementOfTokensOnTheBoard(){
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		
		Position position = new Position(3,3);
		Token token = new Token("X");
		board.place(token, position);
		
		Position alternatePosition = new Position(5,5);
		board.place(token, alternatePosition);
		
		assertEquals(board.getToken(position), token);
	}

	@Test
	public void shouldNotAllowPlacementInTheSamePosition(){
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		
		Position position = new Position(3,3);
		Token token = new Token("X");
		board.place(token, position);
		
		Position alternatePosition = new Position(3,3);
		
		try{
			board.place(token, alternatePosition);
		} catch(TokenAlreadyPresentException placementException){
			return;
		}
		fail("should throw BadPlacementException");
	}
	
	@Test
	public void shouldNotAllowPlacementBeyondTheBoundaries(){
		
	}
	
	@Test
	public void shouldNotAllowAPlayerToPlayConsecutiveTurns() {
		
	}
	
	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveHorizontalPositionsAreFilledBySamePlayer(){
		
	}
}
