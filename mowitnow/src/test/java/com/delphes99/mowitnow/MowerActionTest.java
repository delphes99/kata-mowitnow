package com.delphes99.mowitnow;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.delphes99.mowitnow.action.AdvanceAction;
import com.delphes99.mowitnow.action.IMowerAction;
import com.delphes99.mowitnow.action.MowerActionFactory;
import com.delphes99.mowitnow.action.TurnLeftAction;
import com.delphes99.mowitnow.action.TurnRightAction;
import com.delphes99.mowitnow.exception.IllegalMowerActionException;

public class MowerActionTest {
	private MockMower mower;

	@Before
	public void initializeMock() {
		mower = new MockMower();
	}

	/***************************** Factory *****************************/
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

	/***************************** Action *****************************/
	@Test
	public void should_mower_turn_left_when_G_command() throws Exception {
		IMowerAction actionTurnLeft = MowerActionFactory.getMowerAction("G");
		assertTrue(!mower.isTurningLeft);
		actionTurnLeft.execute(mower);
		assertTrue(mower.isTurningLeft);
	}

	@Test
	public void should_mower_turn_right_when_D_command() throws Exception {
		IMowerAction actionTurnRight = MowerActionFactory.getMowerAction("D");
		assertTrue(!mower.isTurningRight);
		actionTurnRight.execute(mower);
		assertTrue(mower.isTurningRight);
	}

	@Test
	public void should_mower_advance_when_A_command() throws Exception {
		IMowerAction actionAdvance = MowerActionFactory.getMowerAction("A");
		assertTrue(!mower.isAdvancing);
		actionAdvance.execute(mower);
		assertTrue(mower.isAdvancing);
	}

	/***************************** Mower mock *****************************/
	private class MockMower extends EmptyMowerMock {
		boolean isTurningLeft = false;
		boolean isTurningRight = false;
		boolean isAdvancing = false;

		@Override
		public void turnRight() {
			isTurningRight = true;
		}

		@Override
		public void turnLeft() {
			isTurningLeft = true;
		}

		@Override
		public void advance() {
			isAdvancing = true;
		}
	};
}
