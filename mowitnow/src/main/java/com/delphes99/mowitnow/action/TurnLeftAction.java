package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.core.IMower;

public class TurnLeftAction implements IMowerAction {
	protected TurnLeftAction() {
	}

	@Override
	public void execute(IMower mower) {
		mower.turnLeft();
	}
}
