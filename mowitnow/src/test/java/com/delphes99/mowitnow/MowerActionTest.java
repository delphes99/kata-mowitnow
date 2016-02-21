package com.delphes99.mowitnow;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.delphes99.mowitnow.Exception.IllegalMowerActionException;
import com.delphes99.mowitnow.action.AdvanceAction;
import com.delphes99.mowitnow.action.MowerActionFactory;
import com.delphes99.mowitnow.action.TurnLeftAction;
import com.delphes99.mowitnow.action.TurnRightAction;

public class MowerActionTest {
	/* Factory */
	@Test
	public void should_get_turn_left_action_when_G() throws Exception {
		assertTrue(MowerActionFactory.getMowerAction("G") instanceof TurnLeftAction);
	}

	@Test
	public void should_get_turn_right_action_when_D() throws Exception {
		assertTrue(MowerActionFactory.getMowerAction("D") instanceof TurnRightAction);
	}

	@Test
	public void should_get_advance_action_when_A() throws Exception {
		assertTrue(MowerActionFactory.getMowerAction("A") instanceof AdvanceAction);
	}

	@Test(expected = IllegalMowerActionException.class)
	public void should_throw_exception_when_invalid_command() throws Exception {
		MowerActionFactory.getMowerAction("X");
	}

	/* Turn left */
	@Test
	public void should_mower_turn_to_west_when_initial_position() throws Exception {
	}
}
