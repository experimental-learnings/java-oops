package com.learnings.practice.tictactoe;

import java.util.*;
import com.learnings.practice.tictactoe.*;


public class Board {

	private Integer size;
	Map<Position, Token> tokenMap = new HashMap<Position, Token>();
	private Token currentToken;
	private Position currentPosition;
	
	public Board(Integer size) {
		this.size = size;
	}

	public void place(Position position, Token token) {
		isValidMove(position, token);
		tokenMap.put(position, token);
		currentToken = token;
		currentPosition = position;
	}

	private void isValidMove(Position position, Token token) {
		if(isTokenAlreadyPlaced(position)) throw new TokenAlreadyPresentException();
		if(isPlacedOutOfBoundary(position)) throw new OutOFBoundaryException();
		if(isSameTokenPlacedConsecutively(token)) throw new WrongPlayerTurnException();
	}

	private boolean isSameTokenPlacedConsecutively(Token token) {
		return ((currentToken !=null) && (currentToken.equals(token)));
	}

	private boolean isPlacedOutOfBoundary(Position position) {
		return ((position.getRow() > size) || (position.getColumn() > size));
	}

	public Integer getSize() {
		return size;
	}
	
	Position getCurrentPosition() {
    		return currentPosition;
    	}
	public Map<Position, Token> getTokenMap() {
		return Collections.unmodifiableMap(tokenMap);
	}

	public Token getCurrentToken() {
		return currentToken;
	}


	private boolean isTokenAlreadyPlaced(Position position) {
		return tokenMap.containsKey(position);
	}

	public boolean hasTokenAt(Position zeroOne) {
		return tokenMap.containsKey(zeroOne);
	}

}
