package com.learnings.gameoflife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.learnings.gameoflife.BoardStateChangeListener.BoardStateChangeEvent;

public class Board {
	private int size;
	private Map<Position, String> liveCellMapPattern;

	public Board(int size) {
		this.size = size;
		this.liveCellMapPattern = new HashMap<Position, String>();
	}

	public void place(Position position,String liveCell) {
		validate(position, liveCell);
		liveCellMapPattern.put(position, liveCell);
	}

	private void validate(Position position,String token) {
		if (isPlacementOutsideBoundaries(position)) throw new OutOfBoardSizeException();
	}
	private boolean isPlacementOutsideBoundaries(final Position position) {
		return position.getRow() >= size || position.getColumn() >= size;
	}
	public BoardState getBoardState(){
		return new BoardState();
	}

	public class BoardState {

		String getLiveCell(Position position) {
			return liveCellMapPattern.get(position);
		}

		Map<Position, String> getLiveCellMap() {
			return Collections.unmodifiableMap(liveCellMapPattern);
		}

		Integer getSize() {
			return size;
		}

		public boolean hasLiveCellAt(Position position) {
			return liveCellMapPattern.containsKey(position);
		}
	}
}
