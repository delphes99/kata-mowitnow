package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.Mower;

/**
 * Mower can programmatically execute differents actions.
 * 
 * @author Delphes
 */
public interface IMowerAction {
	public void execute(Mower mower);
}
