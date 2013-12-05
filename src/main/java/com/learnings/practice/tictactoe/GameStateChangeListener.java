package com.learnings.practice.tictactoe;

import com.learnings.practice.tictactoe.TicTacToeGame.GameState;


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
