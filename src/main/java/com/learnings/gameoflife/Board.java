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
		liveCellMapPattern.put(position, liveCell);
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
