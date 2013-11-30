package com.learnings.tictactoe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TicTacToeBoard {

	private final Integer size;
	private Map<Position, Token> tokenMap;
	private Map<String, String> playerTokenMap;
	private String currentPlayer;
	private String previousPlayer;
	private String currentState;
	private Integer movementCount = 0;
	private Integer column = 0;
	private Integer forwardMove = 0;
	private Integer backMove = 0;
	private boolean isAvailable = true;
	private Position currentPosition;

	public TicTacToeBoard(final Integer rows, final Integer columns) {
		this.size = rows;
		tokenMap = new HashMap<Position, Token>(rows * columns, 1.0F);
		playerTokenMap = new HashMap<String, String>(2, 1.0F);
		playerTokenMap.put("player1", "X");
		playerTokenMap.put("player2", "O");
	}

	public Integer getRows() {
		return size;
	}

	public String place(Token token, final Position position, String playerName) {
		currentPlayer = playerName;
		if (!(currentPlayer.equals(previousPlayer))) {
			if (position.getRow() < size && position.getColumn() < size) {
				if (tokenMap.containsKey(position)) {
					throw new TokenAlreadyPresentException();
				}
				tokenMap.put(position, token);
				this.currentPosition = position;
			} else {
				throw new OutOfBoardSizeException();
			}
		} else {
			throw new WrongPlayerException();
		}
		previousPlayer = currentPlayer;
		currentPlayer = togglePlayer(currentPlayer);
		paintBoard();
		return currentState;
	}

	public String togglePlayer(String player1) {
		currentPlayer = (currentPlayer).equalsIgnoreCase("player1") ? "player2"
				: "player1";
		return currentPlayer;

	}

	public String play(Token token, final Position position, String playerName) {
		// do{
		place(token, position, playerName);
		paintBoard();
		updateGameStatus(token);
		getGameResult(currentState);
		playerName = currentPlayer;
		// }while(currentState=="Playing");
		return currentState;
	}

	public void begin() {
		currentPlayer = "player1";
		currentState = "Playing";
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
	 * column+1)) == token)){ isAvailable=false; }
	 * 
	 * } if(isAvailable){ checkHorizontalsWon(position, token); } }
	 */
	/*
	 * public void hasWon(){ if(checkHorizontalsWon(position, token)){
	 * currentState = "GameCompleted"; } }
	 */

	public boolean checkRows(Token token) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if ((tokenMap.get(new Position(currentPosition.getRow(), i))) != null
					&& tokenMap.get(new Position(currentPosition.getRow(), i))
							.getCurrentToken().equals(token.getCurrentToken())) {
				count = count + 1;
			}
		}
		return count == size;
	}

	public boolean checkCols(Token token) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (tokenMap.get(new Position(i, currentPosition.getColumn())) != null
					&& tokenMap
							.get(new Position(i, currentPosition.getColumn()))
							.getCurrentToken().equals(token.getCurrentToken())) {
				count = count + 1;
			}
		}
		return count == size;
	}

	public boolean checkDiagonals(Token token) {
		int count = 0;
		int count1 = 0;
		if (currentPosition.getRow() == currentPosition.getColumn()) {
			for (int i = 0; i < size; i++) {
				if (tokenMap.get(new Position(i, i)) != null
						&& tokenMap.get(new Position(i, i)).getCurrentToken()
								.equals(token.getCurrentToken())) {
					count = count + 1;
				}
			}
			return count == size;
		} else if (currentPosition.getRow() + currentPosition.getColumn() == size - 1) {
			for (int i = 0; i < size; i++) {
				if (tokenMap.get(new Position(i, size - i - 1)) != null
						&& tokenMap.get(new Position(i, size - i - 1))
								.getCurrentToken()
								.equals(token.getCurrentToken())) {
					count1 = count1 + 1;
				}
			}
			return count1 == size;
		}
		return count == size;
	}

	public boolean hasWon(Token token) {
		return (checkRows(token) || checkCols(token) || checkDiagonals(token));
	}

	public void paintBoard() {
		for (int row = 0; row < size; ++row) {
			for (int col = 0; col < size; ++col) {
				Iterator it = tokenMap.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<Position, Token> cellData = (Entry<Position, Token>) it
							.next();
					System.out.println(cellData.getValue());
				}
				if (col < size - 1)
					System.out.print("|");
			}
			System.out.println();
			if (row < size - 1) {
				System.out.println("----------------------------");
			}
		}
	}

	public void updateGameStatus(Token token) {
		if (hasWon(token)) {
			currentState = token.getCurrentToken().equals("X") ? "Player1 Won"
					: "Player2 Won";
		} else if (isDraw()) {
			currentState = "Draw";
		}
	}

	public void setTokenMap(Map<Position, Token> tokenMap) {
		this.tokenMap = tokenMap;
	}

	public Token getToken(Position position) {
		return tokenMap.get(position);
	}

	public void getGameResult(String currentState) {
		if (currentState.equals("Player1 Won")) {
			System.out.println("'player1' won! Bye!");
		} else if (currentState.equals("Player2 Won")) {
			System.out.println("'player2' won! Bye!");
		} else if (currentState.equals("Draw")) {
			System.out.println("It's Draw! Bye!");
		}
	}

	public boolean isDraw() {
		for (int row = 0; row < size; ++row) {
			for (int col = 0; col < size; ++col) {
				if (tokenMap.get(new Position(row, col)) == null) {
					return false;
				}
			}
		}
		return true;
	}

}