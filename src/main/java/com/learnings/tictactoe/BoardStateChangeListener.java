package com.learnings.tictactoe;

import com.learnings.tictactoe.TicTacToeBoard.BoardState;

public interface BoardStateChangeListener {
public static final class GameEvent {

	}

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
