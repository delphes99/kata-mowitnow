package com.delphes99.mowitnow;

public class Mower {
	private MowerPosition position;

	public Mower(int x, int y, Direction direction) {
		this.position = new MowerPosition(x, y, direction);
	}

	public MowerPosition getPosition() {
		return position;
	}
}
