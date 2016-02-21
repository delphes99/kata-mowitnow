package com.delphes99.mowitnow;

import com.delphes99.mowitnow.action.IMowerAction;

public class EmptyMowerMock implements IMower {
	@Override
	public void turnLeft() {
	}

	@Override
	public void turnRight() {
	}

	@Override
	public void advance() {
	}

	@Override
	public void addAction(IMowerAction action) {
	}

	@Override
	public MowerPosition getPosition() {
		return null;
	}

	@Override
	public int getActionQueueSize() {
		return 0;
	}

	@Override
	public String runOne() {
		return "";
	}

	@Override
	public String runAll() {
		return "";
	}
}
