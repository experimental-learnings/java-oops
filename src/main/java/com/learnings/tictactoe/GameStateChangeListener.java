package com.learnings.tictactoe;

import com.learnings.tictactoe.TicTacToeGame.GameState;


public interface GameStateChangeListener {
	public final static class GameEvent {
		
	}

	public final static class GameStateChangeEvent {
		private final GameState state;

		GameStateChangeEvent(GameState state){
			this.state = state;
		}

		public GameState getState() {
			return state;
		}
	}

	void onStateChange(GameStateChangeEvent event);
}
