package com.delphes99.mowitnow;

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
		return Direction.getDirectionById(this.right);
	}

	public Direction getLeft() {
		return Direction.getDirectionById(this.left);
	}

	public int getHorizontalDisplacement() {
		return horizontalDisplacement;
	}

	public int getVerticalDisplacement() {
		return verticalDisplacement;
	}

	private static Direction getDirectionById(String id) {
		for (Direction direction : values()) {
			if (direction.id.equals(id)) {
				return direction;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.id;
	}
}
