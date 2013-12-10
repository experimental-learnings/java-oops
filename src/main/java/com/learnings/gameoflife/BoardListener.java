package com.learnings.gameoflife;


public class BoardListener implements BoardStateChangeListener {
	@Override
	public void onStateChange(final BoardStateChangeEvent event) {
		PaintingBoard.paintBoard(event.getState());
	}
}
