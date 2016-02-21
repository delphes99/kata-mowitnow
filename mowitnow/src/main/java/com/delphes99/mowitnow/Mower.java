package com.delphes99.mowitnow;

import java.util.LinkedList;
import java.util.Queue;

import com.delphes99.mowitnow.Exception.MowerIllegalPositionException;
import com.delphes99.mowitnow.action.IMowerAction;

public class Mower implements IMower {
	private Garden garden;
	private MowerPosition position;
	private Queue<IMowerAction> queueAction;

	public Mower(Garden garden, int x, int y, Direction direction) throws MowerIllegalPositionException {
		MowerPosition mowerPosition = new MowerPosition(x, y, direction);

		if (!garden.isCoordinatesIntoGarden(mowerPosition.getCoordinates())) {
			throw new MowerIllegalPositionException("Mower is not into the garden");
		}

		this.garden = garden;
		this.position = mowerPosition;
		this.queueAction = new LinkedList<IMowerAction>();
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

	@Override
	public void addAction(IMowerAction action) {
		this.queueAction.add(action);
	}

	@Override
	public int getActionQueueSize() {
		return this.queueAction.size();
	}

	@Override
	public String runOne() {
		IMowerAction action = this.queueAction.poll();
		if (action != null) {
			action.execute(this);
		}

		return this.toString();
	}

	@Override
	public String runAll() {
		while (!this.queueAction.isEmpty()) {
			this.runOne();
		}

		return this.toString();
	}

	@Override
	public String toString() {
		Coordinate coordinates = position.getCoordinates();
		return coordinates.getX() + " " + coordinates.getX() + " " + position.getDirection().toString();
	}

	public MowerPosition getPosition() {
		return position;
	}
}
