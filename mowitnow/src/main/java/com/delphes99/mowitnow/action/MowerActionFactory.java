package com.delphes99.mowitnow.action;

import com.delphes99.mowitnow.Exception.IllegalMowerActionException;

public class MowerActionFactory {
	public static IMowerAction getMowerAction(String commandAction) throws IllegalMowerActionException {
		switch (commandAction) {
		case "G":
			return new TurnLeftAction();
		case "D":
			return new TurnRightAction();
		case "A":
			return new AdvanceAction();
		default:
			throw new IllegalMowerActionException("Invalid command");
		}
	}
}
