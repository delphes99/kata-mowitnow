package com.delphes99.mowitnow;

import com.delphes99.mowitnow.Exception.MowerIllegalPositionException;

public class Mower implements IMower {
	private Garden garden;
	private MowerPosition position;

	public Mower(Garden garden, int x, int y, Direction direction) throws MowerIllegalPositionException {
		MowerPosition mowerPosition = new MowerPosition(x, y, direction);

		if (!garden.isCoordinatesIntoGarden(mowerPosition.getCoordinates())) {
			throw new MowerIllegalPositionException("Mower is not into the garden");
		}

		this.garden = garden;
		this.position = mowerPosition;
	}

	public MowerPosition getPosition() {
		return position;
	}

	@Override
	public void turnLeft() {
		position.setDirection(position.getDirection().getLeft());
	}

	@Override
	public void turnRight() {
		position.setDirection(position.getDirection().getRight());
	}

	@Override
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
