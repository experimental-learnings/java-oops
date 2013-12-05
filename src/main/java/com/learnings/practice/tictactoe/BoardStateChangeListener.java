package com.learnings.practice.tictactoe;

import com.learnings.practice.tictactoe.Board.BoardState;

public interface BoardStateChangeListener {
public static final class GameEvent {

	}

	public static final class BoardStateChangeEvent {
		private final BoardState state;

		public BoardStateChangeEvent(BoardState state) {
			this.state = state;
		}

		public BoardState getState() {
			return state;
		}
	}

	void onStateChange(BoardStateChangeEvent event);

}
