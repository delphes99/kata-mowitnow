package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.Mower;

public class TurnRightAction implements IMowerAction {
	protected TurnRightAction() {
	}

	@Override
	public void execute(Mower mower) {
		mower.turnRight();
	}
}
