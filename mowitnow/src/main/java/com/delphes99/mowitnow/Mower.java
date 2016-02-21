package com.delphes99.mowitnow;

public class Mower {
	private Garden garden;
	private MowerPosition position;

	public Mower(Garden garden, int x, int y, Direction direction) {
		this.garden = garden;
		this.position = new MowerPosition(x, y, direction);
	}

	public MowerPosition getPosition() {
		return position;
	}

	public void turnLeft() {
		position.setDirection(position.getDirection().getLeft());
	}

	public void turnRight() {
		position.setDirection(position.getDirection().getRight());
	}

	public void advance() {
		Coordinate newCoodinates = estimateNewCoorinates();

		if (garden.isCoordinatesIntoGarden(newCoodinates)) {
			Coordinate coordinates = position.getCoordinates();
			coordinates.setX(newCoodinates.getX());
			coordinates.setY(newCoodinates.getY());
		}
	}

	private Coordinate estimateNewCoorinates() {
		Coordinate coordinates = position.getCoordinates();
		int x = coordinates.getX();
		int y = coordinates.getY();
		Direction direction = position.getDirection();

		x += direction.getHorizontalDisplacement();
		y += direction.getVerticalDisplacement();

		return new Coordinate(x, y);
	}
}
