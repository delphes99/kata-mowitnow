package com.delphes99.mowitnow.core;

import com.delphes99.mowitnow.exception.InvalidDirectionException;

public enum Direction {
	NORTH("N", "W", "E", 0, 1), EAST("E", "N", "S", 1, 0), SOUTH("S", "E", "W", 0, -1), WEST("W", "S", "N", -1, 0);

	private String id;

	private String left;

	private String right;

	private int horizontalDisplacement;

	private int verticalDisplacement;

	private Direction(String id, String left, String right, int horizontalDisplacement, int verticalDisplacement) {
		this.id = id;
		this.left = left;
		this.right = right;
		this.horizontalDisplacement = horizontalDisplacement;
		this.verticalDisplacement = verticalDisplacement;
	}

	public Direction getRight() {
		try {
			return Direction.getDirectionById(this.right);
		} catch (InvalidDirectionException e) {
			// Impossible
			return null;
		}
	}

	public Direction getLeft() {
		try {
			return Direction.getDirectionById(this.left);
		} catch (InvalidDirectionException e) {
			// Impossible
			return null;
		}
	}

	public int getHorizontalDisplacement() {
		return horizontalDisplacement;
	}

	public int getVerticalDisplacement() {
		return verticalDisplacement;
	}

	public static Direction getDirectionById(String id) throws InvalidDirectionException {
		for (Direction direction : values()) {
			if (direction.id.equals(id)) {
				return direction;
			}
		}
		throw new InvalidDirectionException(id + " : Invalid direction");
	}

	@Override
	public String toString() {
		return this.id;
	}
}
