package com.learnings.gameoflife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.learnings.gameoflife.BoardStateChangeListener.BoardStateChangeEvent;

public class Board {
	private int size;
	private Position currentPosition;
	private Integer noOfGenerations;
	private Map<Position, Token> tokenMap;
	private BoardStateChangeListener boardStateChangeListener;

	public Board(int size, Integer gens) {
		this.size = size;
		this.noOfGenerations = gens;
		tokenMap = new HashMap<Position, Token>(size * size, 1.0F);
	}
	
	public void nextGeneration(){
		int count = 1;
	}

	public class BoardState {

		public Token getToken(Position position) {
			return tokenMap.get(position);
		}

		public Map<Position, Token> getTokenMap() {
			return Collections.unmodifiableMap(tokenMap);
		}

		Integer getSize() {
			return size;
		}

		public boolean hasTokenAt(Position[] positions) {
			for (int i = 0; i < positions.length; i++) {
				if (!(tokenMap.containsKey(positions[i])))
					return false;
			}
			return true;
		}

	}

	public void generateFirstGenerationPattern(Position[] positions, Token[] tokens) {
		for (int i = 0; i < positions.length; i++) {
			tokenMap.put(positions[i], tokens[i]);
		}
		if (boardStateChangeListener != null)
			boardStateChangeListener.onStateChange(new BoardStateChangeEvent(
					new BoardState()));
	}

	public void setBoardStateChangeListener(BoardStateChangeListener listener) {
		this.boardStateChangeListener = listener;
	}

}
