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

	public void generateFirstGenerationPattern(Position[] positions, Token[] tokens) {
		for (int i = 0; i < positions.length; i++) {
			validate(tokens[i], positions[i]);
			tokenMap.put(positions[i], tokens[i]);
		}
		if (boardStateChangeListener != null)
			boardStateChangeListener.onStateChange(new BoardStateChangeEvent(
					new BoardState()));
	}
	
	private void validate(Token token, final Position position) {
		if (isPlacementOutsideBoundaries(position)) throw new OutOfBoardSizeException();
	}
	private boolean isPlacementOutsideBoundaries(final Position position) {
		return position.getRow() >= size || position.getColumn() >= size;
	}

	public void nextGeneration(){
		
	}
	
	public boolean isLifeExist(Map<Position,Token> map){
		Map newMap = new HashMap(map.size());
		for(int row=0; row<size; row++){
			for(int col=0; col<size; col++){
					Token above = null;
					Token same = null;
					Token below = null;
					if(col == 0){
						if(row==0){
							above = null;
						}else{
							above.setSubString();//map.get(new Position(row, col));
							above
						}
						above = (row == 0) ? null : map.get(new Position(row-1, col))
					}
					
			}
		}
		
		return false;
	}

	public void setBoardStateChangeListener(BoardStateChangeListener listener) {
		this.boardStateChangeListener = listener;
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

}
