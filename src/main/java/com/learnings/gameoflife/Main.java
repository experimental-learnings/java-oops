package com.learnings.gameoflife;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertTrue;

import org.mockito.ArgumentCaptor;

import com.learnings.gameoflife.BoardStateChangeListener.BoardStateChangeEvent;


public class Main {

	public static void main(String str[]){
		String liveCell = "L";
		final Integer size = 3;
		Position zeroOne = new Position(0, 1);
		Board board = new Board(size);
				
		board.setBoardStateChangeListener(new BoardListener());
		
		board.place(zeroOne, liveCell);
		
		
	}
}
