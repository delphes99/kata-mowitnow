package com.delphes99.mowitnow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.delphes99.mowitnow.Exception.GardenDimensionException;

public class Garden {
	private int width;

	private int height;

	private Queue<IMower> mowerQueue;

	public Garden(int width, int height) throws GardenDimensionException {
		checkDimension(width, height);

		this.width = width;
		this.height = height;

		this.mowerQueue = new LinkedList<IMower>();
	}

	private void checkDimension(int width, int height) throws GardenDimensionException {
		if (width <= 0) {
			throw new GardenDimensionException("Garden width must be positive");
		}
		if (height <= 0) {
			throw new GardenDimensionException("Garden height must be positive");
		}
	}

	public boolean isCoordinatesIntoGarden(Coordinate coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();

		boolean isXValid = x >= 0 && x <= width;
		boolean isYValid = y >= 0 && y <= height;

		return isXValid && isYValid;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void addMower(IMower mower) {
		this.mowerQueue.add(mower);
	}

	public Queue<IMower> getMowerQueue() {
		return mowerQueue;
	}

	public String activateAllMowers() {
		List<String> allPositions = new ArrayList<>();
		for (IMower mower : this.getMowerQueue()) {
			allPositions.add(mower.runAll());
		}

		return String.join("\n", allPositions);
	}
}
