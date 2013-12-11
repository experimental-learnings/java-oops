package com.learnings.tictactoe;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;

import java.io.Console;
import org.testng.annotations.Test;
import com.learnings.gameoflife.Board;
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
		Console cons = System.console(); 
		board.place(zeroOne, liveCell);
		assertEquals(board.getBoardState().hasLiveCellAt(zeroOne), true);
	}
	
	@Test
	public void ShouldBeAbleToPlaceAllLiveCellWithinTheBoundaries() {
		String liveCell = "L";
		final Integer size = 3;
		Position zeroOne = new Position(0, 5);
		Board board = new Board(size);
		try{
			board.place(zeroOne, liveCell);
		}catch(OutOfBoardSizeException e){
			return;
		}
		fail(" should throw OutOfBoardSizeException");
	
	} 
	@Test
	public void shouldInitializeBoardWithFirstGeneration() {
		
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
