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
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		Position position = new Position(1,1);
		Token token = new Token("X");
		board.place(token, position);
		

		Position alternatePosition = new Position(10,11);
		try{
			board.place(token, alternatePosition);
		} catch(OutOfBoardSizeException boundaryException){
			return;
		}
		fail("should throw OutOfBoadSizeException");
		
	}
	
	@Test
	public void shouldNotAllowAPlayerToPlayConsecutiveTurns() {
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		Position position = new Position(1,1);
		Position alternateposition = new Position(2,2);
		Token token = new Token("X");
		
		board.place(token, position);
		
		try{
			board.place(token, position);
		} catch (InvalidTurnException e){
			
		}
		

		
	}
	
	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveHorizontalPositionsAreFilledBySamePlayer(){
		
	}
	
	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveVerticalPositionsAreFilledBySamePlayer(){
		
	}
	
	@Test
	public void shouldDeclareWinnerWhenThreeConsecutiveDiagonalPositionsAreFilledBySamePlayer(){
		
	}
}
