package com.learnings.gameoflife;

public interface BoardInterface {
		void place(Position position, String liveCell);
		void getBoardState();
}
