package com.delphes99.mowitnow;

import com.delphes99.mowitnow.action.IMowerAction;
import com.delphes99.mowitnow.core.IMower;
import com.delphes99.mowitnow.core.MowerPosition;

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
