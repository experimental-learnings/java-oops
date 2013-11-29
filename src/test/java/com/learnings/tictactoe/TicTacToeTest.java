package com.learnings.tictactoe;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;


public class TicTacToeTest {
	

	@Test
	public void shouldAllowPlacementOfTokensOnTheBoard(){
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		
		Position position = new Position(3,3);
		Token token = new Token("X");
		Player player = new Player("player1");
		board.place(token, position, "player1");
		
		Position alternatePosition = new Position(5,5);
		board.place(token, alternatePosition, "player2");
		
		assertEquals(board.getToken(position), token);
	}

	@Test
	public void shouldNotAllowPlacementInTheSamePosition(){
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		
		Position position = new Position(3,3);
		Token token = new Token("X");
		Player player = new Player("player1");
		board.place(token, position, "player1");
		
		Position alternatePosition = new Position(3,3);
		
		try{
			board.place(token, alternatePosition, "player2");
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
		Player player = new Player("player1");
		board.place(token, position, "player1");
		

		Position alternatePosition = new Position(10,11);
		try{
			board.place(token, alternatePosition, "player2");
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
		Position alternatePosition = new Position(2,2);
		Token token = new Token("X");
		Player player = new Player("player1");
		
		board.place(token, position, "player1");
		
		try{
			board.place(token, position, "player1");
		} catch (WrongPlayerException e){
			
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
