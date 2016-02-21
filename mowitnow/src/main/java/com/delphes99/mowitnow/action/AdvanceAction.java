package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.Mower;

public class AdvanceAction implements IMowerAction {
	protected AdvanceAction() {
	}

	@Override
	public void execute(Mower mower) {
		mower.advance();
	}
}
