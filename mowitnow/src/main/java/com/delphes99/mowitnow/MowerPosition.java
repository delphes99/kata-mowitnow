package com.delphes99.mowitnow;

public class MowerPosition {
	private int x;
	private int y;
	private Direction direction;

	public MowerPosition(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
