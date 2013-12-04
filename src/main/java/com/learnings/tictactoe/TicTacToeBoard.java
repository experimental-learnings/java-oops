package com.learnings.tictactoe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.learnings.tictactoe.BoardStateChangeListener.BoardStateChangeEvent;
import com.learnings.tictactoe.exceptions.OutOfBoardSizeException;
import com.learnings.tictactoe.exceptions.TokenAlreadyPresentException;
import com.learnings.tictactoe.exceptions.WrongPlayerException;

public class TicTacToeBoard {

	private final Integer size;
	private Map<Position, Token> tokenMap;
	private BoardStateChangeListener boardStateChangeListener;
	private Position currentPosition;
	private Token currentToken;

	public TicTacToeBoard(final Integer rows, final Integer columns) {
		this.size = rows;
		tokenMap = new HashMap<Position, Token>(rows * columns, 1.0F);
	}

	public void place(Token token, final Position position) {
		validate(token, position);
		tokenMap.put(position, token);
		currentToken = token;
		currentPosition = position;
		if(boardStateChangeListener != null)
			boardStateChangeListener.onStateChange(new BoardStateChangeEvent(new BoardState()));
	}
	
	private void validate(Token token, final Position position) {
		if (isSameTokenPlacedConsecutively(token)) throw new WrongPlayerException();
		if (isPlacementOutsideBoundaries(position)) throw new OutOfBoardSizeException();
		if (hasTokenAt(position)) throw new TokenAlreadyPresentException();
	}
	
	private boolean isPlacementOutsideBoundaries(final Position position) {
		return position.getRow() > size || position.getColumn() > size;
	}

	private boolean isSameTokenPlacedConsecutively(Token token) {
		return currentToken != null && (currentToken.equals(token));
	}
	
	public Token getToken(Position position) {
		return tokenMap.get(position);
	}

	Integer getSize() {
		return size;
	}
	
	Map<Position, Token> getTokenMap() {
		return Collections.unmodifiableMap(tokenMap);
	}

	Position getCurrentPosition() {
		return currentPosition;
	}

	public class BoardState {
	
		public boolean hasTokenAt(Position position) {
			return TicTacToeBoard.this.hasTokenAt(position);
		}

		public Token getToken(Position position) {
			return tokenMap.get(position);
		}
		public Map<Position, Token> getTokenMap() {
			return Collections.unmodifiableMap(tokenMap);
		}
		Integer getSize() {
			return size;
		}
		
	}
	void setBoardStateChangeListener(BoardStateChangeListener boardStateChangeListener) {
		this.boardStateChangeListener = boardStateChangeListener;
	}

	public boolean hasTokenAt(Position position) {
		return tokenMap.containsKey(position);
	}

}