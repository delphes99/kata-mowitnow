package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.delphes99.mowitnow.action.IMowerAction;

public class MowerProgrammTest {
	private IMower mower;
	private StringBuilder execution;

	@Before
	public void initializeMower() throws Exception {
		Garden garden = new Garden(5, 5);
		mower = new Mower(garden, 0, 0, Direction.NORTH);
		execution = new StringBuilder();
	}

	@Test
	public void should_add_action_when_adding_action() throws Exception {
		mower.addAction(new MowerActionMock("1", execution));
		assertEquals(1, mower.getActionQueueSize());
	}

	/* Run one */
	@Test
	public void should_do_nothing_when_run_one_with_no_action() throws Exception {
		assertEquals(0, mower.getActionQueueSize());
		mower.runOne();
		assertEquals(0, mower.getActionQueueSize());
	}

	@Test
	public void should_remove_action_when_run_one() throws Exception {
		mower.addAction(new MowerActionMock("1", execution));
		assertEquals(1, mower.getActionQueueSize());
		mower.runOne();
		assertEquals(0, mower.getActionQueueSize());
	}

	@Test
	public void should_execute_action_when_run_one() throws Exception {
		mower.addAction(new MowerActionMock("1", execution));
		mower.runOne();
		assertEquals("1", execution.toString());
	}

	@Test
	public void should_execute_only_1_action_when_run_one() throws Exception {
		mower.addAction(new MowerActionMock("1", execution));
		mower.addAction(new MowerActionMock("2", execution));
		assertEquals(2, mower.getActionQueueSize());
		mower.runOne();
		assertEquals(1, mower.getActionQueueSize());
	}

	@Test
	public void should_execute_only_first_action_when_run_one() throws Exception {
		mower.addAction(new MowerActionMock("1", execution));
		mower.addAction(new MowerActionMock("2", execution));
		mower.runOne();
		assertEquals("1", execution.toString());
	}

	/* Run all */@Test
	public void should_do_nothing_when_run_all_with_no_action() throws Exception {
		assertEquals(0, mower.getActionQueueSize());
		mower.runAll();
		assertEquals(0, mower.getActionQueueSize());
	}

	@Test
	public void should_remove_all_action_when_run_all() throws Exception {
		mower.addAction(new MowerActionMock("1", execution));
		mower.addAction(new MowerActionMock("2", execution));
		assertEquals(2, mower.getActionQueueSize());
		mower.runAll();
		assertEquals(0, mower.getActionQueueSize());
	}

	@Test
	public void should_execute_all_action_when_run_one() throws Exception {
		mower.addAction(new MowerActionMock("1", execution));
		mower.addAction(new MowerActionMock("2", execution));
		mower.runAll();
		assertEquals("12", execution.toString());
	}

	@Test
	public void should_get_positionq_when_run_one() throws Exception {
		String position = mower.runOne();
		assertEquals("0 0 N", position);
	}

	@Test
	public void should_get_positionq_when_run_all() throws Exception {
		String position = mower.runAll();
		assertEquals("0 0 N", position);
	}

	@Test
	public void should_get_new_positionq_when_run_all() throws Exception {
		mower.addAction(new MowerActionPositionMock(2, 2));
		String position = mower.runAll();
		assertEquals("2 2 N", position);
	}

	/* Action mock */
	private class MowerActionMock implements IMowerAction {
		private String id;
		private StringBuilder excecution;

		public MowerActionMock(String id, StringBuilder excecution) {
			this.id = id;
			this.excecution = excecution;
		}

		@Override
		public void execute(IMower mower) {
			excecution.append(id);
		}
	}

	private class MowerActionPositionMock implements IMowerAction {
		private int x;
		private int y;

		public MowerActionPositionMock(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public void execute(IMower mower) {
			mower.getPosition().getCoordinates().setX(this.x);
			mower.getPosition().getCoordinates().setY(this.y);
		}

	}
}
