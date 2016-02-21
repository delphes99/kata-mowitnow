package com.delphes99.mowitnow;

public enum Direction {
	NORTH("N", "W", "E"), EAST("E", "N", "S"), SOUTH("S", "E", "W"), WEST("W", "S", "N");

	private String id;

	private String left;

	private String right;

	private Direction(String id, String left, String right) {
		this.id = id;
		this.left = left;
		this.right = right;
	}

	public Direction getRight() {
		return Direction.getDirectionById(this.right);
	}

	public Direction getLeft() {
		return Direction.getDirectionById(this.left);
	}

	private static Direction getDirectionById(String id) {
		for (Direction direction : values()) {
			if (direction.id.equals(id)) {
				return direction;
			}
		}
		return null;
	}
}
