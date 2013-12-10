package com.learnings.tictactoe;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import com.learnings.gameoflife.Board;
import com.learnings.gameoflife.BoardStateChangeListener;
import com.learnings.gameoflife.BoardStateChangeListener.BoardStateChangeEvent;
import com.learnings.gameoflife.OutOfBoardSizeException;
import com.learnings.gameoflife.Position;
import com.learnings.gameoflife.Token;

public class GameOfLifeTest {
	// Assume that its a square board of int size
	
	@Test
	public void shouldBeAbleToGenerateFirstGenerationAndDisplay() {
		Token deadCell = new Token("D");
		Token aliveCell = new Token("L");
		final Integer size = 3;
		final Integer noOfGenerations = 3;
		Position zeroZero = new Position(0, 0);
		Position zeroOne = new Position(0, 1);
		Position zeroTwo = new Position(0, 2);
		Position oneZero = new Position(1, 0);
		Position oneOne = new Position(1, 1);
		Position oneTwo = new Position(2, 2);
		Position twoZero = new Position(2, 0);
		Position twoOne = new Position(1, 1);
		Position twoTwo = new Position(2, 2);
		final Position[] positions = {zeroZero,zeroOne,zeroTwo,oneZero,oneOne,oneTwo,twoZero,twoOne,twoTwo};
		Token []tokens = {deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell};
		Board board = new Board(size, noOfGenerations);
		
		/*
		board.setBoardStateChangeListener(new BoardStateChangeListener(){

			@Override
			public void onStateChange(BoardStateChangeEvent event) {
				BoardState boardState = event.getState();
				assertTrue(boardState.hasTokenAt(positions));
				PaintingBoard.paintBoard(boardState);
				//assertEquals(boardState.getToken(position), token);
				//status[0] = true;
			}
		});
		*/
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);
		board.generateFirstGenerationPattern(positions, tokens);
		
		ArgumentCaptor<BoardStateChangeEvent> argument = ArgumentCaptor.forClass(BoardStateChangeEvent.class);
		verify(listener).onStateChange(argument.capture());
		System.out.println(argument.getValue().getState().hasTokenAt(positions));
    	assertTrue(argument.getValue().getState().hasTokenAt(positions));
    	
	}
	
	@Test
	public void allLiveAndDeadCellTokensShouldBeWithinTheBoundaries() {
		Token deadCell = new Token("D");
		Token aliveCell = new Token("L");
		final Integer size = 3;
		final Integer noOfGenerations = 3;
		Position zeroZero = new Position(0, 0);
		Position zeroOne = new Position(0, 1);
		Position zeroTwo = new Position(0, 2);
		Position oneZero = new Position(1, 0);
		Position oneOne = new Position(1, 1);
		Position oneTwo = new Position(2, 2);
		Position twoZero = new Position(2, 0);
		Position twoOne = new Position(1, 1);
		Position twoThree = new Position(2, 3);  //out of board size 
		final Position[] positions = {zeroZero,zeroOne,zeroTwo,oneZero,oneOne,oneTwo,twoZero,twoOne,twoThree};
		Token []tokens = {deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell};
		Board board = new Board(size, noOfGenerations);

		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);
		try{
			board.generateFirstGenerationPattern(positions, tokens);
		}catch(OutOfBoardSizeException e){
			return;
		}
		fail("should throw OutOfBoardSizeException");

	} 
	
	//Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	@Test
	public void liveCellDiesBecauseOfUnderPopulation() {
		Token deadCell = new Token("D");
		Token aliveCell = new Token("L");
		final Integer size = 3;
		final Integer noOfGenerations = 3;
		Position zeroZero = new Position(0, 0);
		Position zeroOne = new Position(0, 1);
		Position zeroTwo = new Position(0, 2);
		Position oneZero = new Position(1, 0);
		Position oneOne = new Position(1, 1);
		Position oneTwo = new Position(2, 2);
		Position twoZero = new Position(2, 0);
		Position twoOne = new Position(1, 1);
		Position twoTwo = new Position(2, 2);
		final Position[] positions = {zeroZero,zeroOne,zeroTwo,oneZero,oneOne,oneTwo,twoZero,twoOne,twoTwo};
		Token []tokens = {deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell,deadCell,aliveCell,deadCell};
		Board board = new Board(size, noOfGenerations);
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);
		board.generateFirstGenerationPattern(positions, tokens);
		
		ArgumentCaptor<BoardStateChangeEvent> argument = ArgumentCaptor.forClass(BoardStateChangeEvent.class);
		verify(listener).onStateChange(argument.capture());
		System.out.println(argument.getValue().getState().hasTokenAt(positions));
    	assertTrue(argument.getValue().getState().hasTokenAt(positions));

	}
	
	//Any live cell with two or three live neighbours lives on to the next generation.
	@Test
	public void liveCellStillAliveToNextGeneration() {
	
	}
	
	//Any live cell with more than three live neighbours dies, as if by overcrowding.
	@Test
	public void liveCellDiesBecauseOfOverPopulation() {
	
	}
	
	//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	@Test
	public void deadCellBecomesAliveBecauseOfReproduction() {
	
	}
}
