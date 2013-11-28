package com.learnings.tictactoe;

import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class TicTacToeTest {
	
	@Test
	public void shouldInitializeBoard(){
		final Integer rows = 10;
		TicTacToeBoard board = new TicTacToeBoard(rows, 10);
		
		assertEquals(board.getRows(), rows);
		
	}
	
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
		
	}
}
