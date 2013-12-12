package com.learnings.gameoflife;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {
	private int size;
	private Map<Position, String> liveCellMapPattern;
	private Position currentPosition;

	public Board(int size) {
		this.size = size;
		this.liveCellMapPattern = new HashMap<Position, String>();
	}

	public void place(Position position,String liveCell) {
		validate(position, liveCell);
		currentPosition = position;
		liveCellMapPattern.put(position, liveCell);
	}

	
	public Map<Position, String> computeNextGen() {
		Map<Position, String> tempMap = new HashMap<Position, String>();
		for(int row=0; row<size ;row++){
			for(int col=0;col<size;col++){
				String above = "";
				String same = "";
				String below = "";
				if(col == 0) {
					above = (row == 0) ? null : subString(row -1 , col, col+1);
					same = liveCellMapPattern.get(new Position(row, col+1));
					below = (row == size - 1) ? null : subString(row+1, col, col+1);
				}else if(col == size-1){
					above = (row == 0) ? null : subString(row-1, col-1, col);
					same = liveCellMapPattern.get(new Position(row, col-1));
					below = (row == size - 1) ? null : subString(row+1, col-1, col);
				}else{
					above = (row == 0) ? null : subString(row-1, col-1, col)+" "+liveCellMapPattern.get(new Position(row-1, col+1));
					same = subString(row, col-1, col+1);
					below = (row == size - 1) ? null : subString(row+1, col-1, col)+" "+liveCellMapPattern.get(new Position(row+1, col+1));
				}
				int liveNeighbors = getLiveNeighbors(above, same, below);
				if (liveNeighbors < 2 || liveNeighbors > 3) {
					tempMap.put(new Position(row,col), null);
				}else {
					tempMap.put(new Position(row, col), liveCellMapPattern.get(new Position(row, col)));
				}
			}
		}
		return tempMap;
	}
	public static int getLiveNeighbors(String above, String same, String below) {
		int count = 0;
		if (above != null) {
			for(int i=0; i<above.length();i++){
				if(above.charAt(i) == 'L')
					count++;
			}
		}
		if(same !=null){
			for(int i=0; i<same.length();i++){
				if(same.charAt(i) == 'L')
					count++;
			}
		}
		if (below != null) {
			for(int i=0; i<below.length();i++){
				if(below.charAt(i) == 'L')
					count++;
			}
		}
		return count;
	}
	
	public void updateGen(){
		liveCellMapPattern=computeNextGen();
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
	
	public String subString(int row,int initialCol,int lastCol){
		return liveCellMapPattern.get(new Position(row, initialCol))+" "+liveCellMapPattern.get(new Position(row, lastCol));
	}

	
	public class BoardState {

		String getLiveCell(Position position) {
			return liveCellMapPattern.get(position);
		}

		Integer getSize() {
			return size;
		}

		public boolean hasLiveCellAt(Position position) {
			return liveCellMapPattern.get(position) != null ;
		}
	}
}
