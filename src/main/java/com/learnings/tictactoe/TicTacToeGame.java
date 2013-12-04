package com.learnings.tictactoe;

import com.learnings.tictactoe.GameStateChangeListener.GameStateChangeEvent;

public class TicTacToeGame {
	private GameStateChangeListener gameStateChangeListener;
	private TicTacToeBoard board;
	private GameState currentGameState;

	public TicTacToeGame(TicTacToeBoard board) {
		this.board=board;
		init();
		
	}
	private void init(){
		currentGameState = GameState.PLAYING;
	}

	public boolean isRowsWin(Token token) {
		int count = 0;
		for (int i = 0; i < board.getSize(); i++) {
			if ((board.getTokenMap().get(new Position(board.getCurrentPosition().getRow(), i))) != null
					&& board.getTokenMap().get(new Position(board.getCurrentPosition().getRow(), i))
							.getCurrentToken().equals(token.getCurrentToken())) {
				count = count + 1;
			}
		}
		return count == board.getSize();
	}

	public boolean isColumnsWin(Token token) {
		int count = 0;
		for (int i = 0; i < board.getSize(); i++) {
			if (board.getTokenMap().get(new Position(i, board.getCurrentPosition().getColumn())) != null
					&& board.getTokenMap()
							.get(new Position(i, board.getCurrentPosition().getColumn()))
							.getCurrentToken().equals(token.getCurrentToken())) {
				count = count + 1;
			}
		}
		return count == board.getSize();
	}

	public boolean isDiagonalsWin(Token token) {
		int count = 0;
		int count1 = 0;
		if (board.getCurrentPosition().getRow() == board.getCurrentPosition().getColumn()) {
			for (int i = 0; i < board.getSize(); i++) {
				if (board.getTokenMap().get(new Position(i, i)) != null
						&& board.getTokenMap().get(new Position(i, i)).getCurrentToken()
								.equals(token.getCurrentToken())) {
					count = count + 1;
				}
			}
			return count == board.getSize();
		} else if (board.getCurrentPosition().getRow() + board.getCurrentPosition().getColumn() == board.getSize() - 1) {
			for (int i = 0; i < board.getSize(); i++) {
				if (board.getTokenMap().get(new Position(i, board.getSize() - i - 1)) != null
						&& board.getTokenMap().get(new Position(i, board.getSize() - i - 1))
								.getCurrentToken()
								.equals(token.getCurrentToken())) {
					count1 = count1 + 1;
				}
			}
			return count1 == board.getSize();
		}
		return count == board.getSize();
	}

	public boolean hasWon(Token token) {
		return (isRowsWin(token) || isColumnsWin(token) || isDiagonalsWin(token));
	}
	
	public void getGameStatus(Token token) {
		if (hasWon(token)) {
			currentGameState = token.getCurrentToken().equals("X") ? GameState.PLAYER1 : GameState.PLAYER2;
		} else if (isDraw()) {
			currentGameState = GameState.DRAW;
		}
		if(gameStateChangeListener != null)
			gameStateChangeListener.onStateChange(new GameStateChangeEvent(currentGameState));
		
	}
	
	public static void printGameResult(GameState currentGameState) {
		if (currentGameState.equals(GameState.PLAYER1)) {
			System.out.println("'player1' won! Congrates!");
		} else if (currentGameState.equals(GameState.PLAYER2)) {
			System.out.println("'player2' won! Congrates!");
		} else if (currentGameState.equals(GameState.DRAW)) {
			System.out.println("It's Draw! Try Again!");
		}
	}

	public boolean isDraw() {
		for (int row = 0; row < board.getSize(); ++row) {
			for (int col = 0; col < board.getSize(); ++col) {
				if (board.getTokenMap().get(new Position(row, col)) == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	public enum GameState {
		PLAYING, DRAW, PLAYER1, PLAYER2;
		
		public GameState getGameState(GameState curreGameState) {
			return curreGameState;
		}
		
		
	}

	void setGameStateChangeListener(GameStateChangeListener gameStateChangeListener) {
		this.gameStateChangeListener = gameStateChangeListener;
	}
	// for rows
	/*
	 * public void checkHorizontalsWon(Position position,Token token){ if(column
	 * == 0){ column = position.getColumn(); } if(column!=0){
	 * if(!(tokenMap.get(new Position(position.getRow(), column-1))!=null) &&
	 * !(tokenMap.get(new Position(position.getRow(), column-1)) == token)){
	 * isAvailable=false; } column--; }
	 * 
	 * if(size != column+1){ if(!(tokenMap.get(new Position(position.getRow(),
	 * column+1))!=null) && !(tokenMap.get(new Position(position.getRow(),
	 * 
	 * column+1)) == token)){ isAvailable=false; }
	 * 
	 * } if(isAvailable){ checkHorizontalsWon(position, token); } }
	 */
	/*
	 * public void hasWon(){ if(checkHorizontalsWon(position, token)){
	 * currentState = "GameCompleted"; } }
	 */


}
