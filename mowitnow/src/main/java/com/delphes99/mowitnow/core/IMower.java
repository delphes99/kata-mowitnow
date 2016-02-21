package com.delphes99.mowitnow.core;

import com.delphes99.mowitnow.action.IMowerAction;

public interface IMower {
	void turnLeft();

	void turnRight();

	void advance();

	void addAction(IMowerAction action);

	MowerPosition getPosition();

	/**
	 * Number of actions in the queue
	 * 
	 * @return int
	 */
	int getActionQueueSize();

	/**
	 * Run the first action in the queue
	 * 
	 * @return String the mower position
	 */
	String runOne();

	/**
	 * Run all the action in the queue
	 * 
	 * @return String the mower position
	 */
	String runAll();
}