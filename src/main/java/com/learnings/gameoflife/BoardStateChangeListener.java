package com.learnings.gameoflife;

import com.learnings.gameoflife.Board.BoardState;

public interface BoardStateChangeListener {

	public static final class BoardStateChangeEvent {
		private final BoardState state;

		BoardStateChangeEvent(final BoardState state) {
			this.state = state;
		}

		public BoardState getState() {
			return state;
		}
	}

	void onStateChange(BoardStateChangeEvent event);

}
