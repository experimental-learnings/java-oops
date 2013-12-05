package com.learnings.practice.tictactoe;

import com.learnings.practice.tictactoe.Board.BoardState;

public class BoardListener implements BoardStateChangeListener {
	@Override
	public void onStateChange(final BoardStateChangeEvent event) {
		BoardState boardState = event.getState();
		PaintingBoard paintBoard = new PaintingBoard();
		paintBoard.paintBoard(boardState);
	}

}
