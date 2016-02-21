package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.IMower;

public class TurnRightAction implements IMowerAction {
	protected TurnRightAction() {
	}

	@Override
	public void execute(IMower mower) {
		mower.turnRight();
	}
}
