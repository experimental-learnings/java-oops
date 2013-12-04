package com.learnings.tictactoe;

import com.learnings.tictactoe.TicTacToeBoard.BoardState;

public class BoardListener implements BoardStateChangeListener {
	@Override
	public void onStateChange(final BoardStateChangeEvent event) {
		BoardState boardState = event.getState();
		PaintingBoard paintBoard = new PaintingBoard();
		paintBoard.paintBoard(boardState);
	}

}
