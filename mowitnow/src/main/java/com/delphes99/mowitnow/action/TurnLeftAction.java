package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.Mower;

public class TurnLeftAction implements IMowerAction {
	protected TurnLeftAction() {
	}

	@Override
	public void execute(Mower mower) {
		mower.turnLeft();
	}
}
