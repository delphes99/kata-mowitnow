package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.IMower;

public class AdvanceAction implements IMowerAction {
	protected AdvanceAction() {
	}

	@Override
	public void execute(IMower mower) {
		mower.advance();
	}
}
