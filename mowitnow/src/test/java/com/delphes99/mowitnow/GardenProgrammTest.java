package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.delphes99.mowitnow.core.Garden;

public class GardenProgrammTest {
	private Garden garden;

	@Before
	public void initializeGarden() throws Exception {
		garden = new Garden(5, 5);
	}

	@Test
	public void should_run_all_the_mowers_when_activate_all_mowers() throws Exception {
		AutomaticMowerMock mock1 = new AutomaticMowerMock("1");
		AutomaticMowerMock mock2 = new AutomaticMowerMock("2");
		garden.addMower(mock1);
		garden.addMower(mock2);
		garden.activateAllMowers();
		assertTrue(mock1.isRunAll);
		assertTrue(mock2.isRunAll);
	}

	@Test
	public void should_run_all_the_mowers_in_add_order_when_activate_all_mowers() throws Exception {
		AutomaticMowerMock mock1 = new AutomaticMowerMock("1");
		AutomaticMowerMock mock2 = new AutomaticMowerMock("2");
		garden.addMower(mock1);
		garden.addMower(mock2);
		String allPositions = garden.activateAllMowers();
		assertEquals("1\n2", allPositions);
	}

	/***************************** Mower mock *****************************/
	private class AutomaticMowerMock extends EmptyMowerMock {
		private boolean isRunAll = false;
		private String id;

		public AutomaticMowerMock(String id) {
			this.id = id;
		}

		@Override
		public String runAll() {
			isRunAll = true;

			return this.id;
		}
	}
}
