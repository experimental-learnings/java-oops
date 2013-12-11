package com.learnings.tictactoe;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;
import java.util.HashMap;
import java.util.Map;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;
import com.learnings.gameoflife.Board;
import com.learnings.gameoflife.BoardStateChangeListener;
import com.learnings.gameoflife.BoardStateChangeListener.BoardStateChangeEvent;
import com.learnings.gameoflife.OutOfBoardSizeException;
import com.learnings.gameoflife.Position;

public class GameOfLifeTest {
	// Assume that its a square board of int size
	
	
	@Test
	public void ShouldBeAbleToPlaceALiveCellOnTheBoard() {
		String liveCell = "L";
		final Integer size = 3;
		Position zeroOne = new Position(0, 1);
		Board board = new Board(size);
		
		BoardStateChangeListener listener = mock(BoardStateChangeListener.class);
		board.setBoardStateChangeListener(listener);
		
		board.place(zeroOne, liveCell);
		
		ArgumentCaptor<BoardStateChangeEvent> argument = ArgumentCaptor.forClass(BoardStateChangeEvent.class);
		verify(listener).onStateChange(argument.capture());
    	assertTrue(argument.getValue().getState().hasLiveCellAt(zeroOne));
    
	}
	@Test
	public void shouldInitializeBoardWithFirstGeneration() {
		
	}
	
	@Test
	public void ShouldBeAbleToPlaceAllLiveCellWithinTheBoundaries() {
		
	} 
	
	//Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	@Test
	public void shouldKillLiveCellOnUnderPopulation() {
		
	}
	
	//Any live cell with two or three live neighbours lives on to the next generation.
	@Test
	public void shouldBeAbleToContinueLiveCellToNextGeneration() {
	
	}
	
	//Any live cell with more than three live neighbours dies, as if by overcrowding.
	@Test
	public void shouldKillLiveCellOnOverPopulation() {
	
	}
	
	//Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	@Test
	public void shouldBeAbleToGiveLifeTodeadCellOnReproduction() {
	
	}
}
