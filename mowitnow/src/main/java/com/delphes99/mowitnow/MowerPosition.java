package com.delphes99.mowitnow;

public class MowerPosition {
	private Coordinate coordinates;
	private Direction direction;

	public MowerPosition(int x, int y, Direction direction) {
		this.coordinates = new Coordinate(x, y);
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Coordinate getCoordinates() {
		return coordinates;
	}
}
