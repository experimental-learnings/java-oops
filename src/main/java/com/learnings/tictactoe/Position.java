package com.learnings.tictactoe;

public class Position {

	private Integer row;
	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	private Integer column;

	public Position(final Integer row, final Integer column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((row == null) ? 0 : row.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
			return false;
		if (row == null) {
			if (other.row != null)
				return false;
		} else if (!row.equals(other.row))
			return false;
		return true;
	}

}
