package com.learnings.practice.tictactoe;

import com.learnings.practice.tictactoe.TicTacToeGame.GameState;

public class GameListener implements GameStateChangeListener{

	@Override
	public void onStateChange(final GameStateChangeEvent event) {
		GameState gameState = event.getState();
		System.out.println(gameState);
		TicTacToeGame.printGameResult(gameState);

	}

}
