package com.learnings.gameoflife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import com.learnings.gameoflife.BoardStateChangeListener.BoardStateChangeEvent;

public class Board {
	private int size;
	private Map<Position, String> liveCellMapPattern;
	private BoardStateChangeListener boardStateChangeListener;

	public Board(int size) {
		this.size = size;
		this.liveCellMapPattern = new HashMap<Position, String>();
	}

	public void place(Position position,String liveCell) {
		liveCellMapPattern.put(position, liveCell);
		if (boardStateChangeListener != null)
			boardStateChangeListener.onStateChange(new BoardStateChangeEvent(
					new BoardState()));
	}
	

	public void setBoardStateChangeListener(BoardStateChangeListener listener) {
		this.boardStateChangeListener = listener;
	}

	public class BoardState {

		public String getLiveCell(Position position) {
			return liveCellMapPattern.get(position);
		}

		public Map<Position, String> getLiveCellMap() {
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
