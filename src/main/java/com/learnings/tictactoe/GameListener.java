package com.learnings.tictactoe;

import com.learnings.tictactoe.TicTacToeBoard.BoardState;
import com.learnings.tictactoe.TicTacToeGame.GameState;

public class GameListener implements GameStateChangeListener{

	@Override
	public void onStateChange(final GameStateChangeEvent event) {
		GameState gameState = event.getState();
		System.out.println(gameState);
		TicTacToeGame.printGameResult(gameState);

	}

}
