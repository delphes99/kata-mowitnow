package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MowerTest {
	@Test
	public void should_have_position_when_new_mower() throws Exception {
		Mower mower = new Mower(0, 1, Direction.NORTH);
		assertNotNull(mower.getPosition());
	}

	@Test
	public void should_get_position_attributes_when_new_mower() throws Exception {
		Mower mower = new Mower(0, 1, Direction.NORTH);
		assertEquals(0, mower.getPosition().getX());
		assertEquals(1, mower.getPosition().getY());
		assertEquals(Direction.NORTH, mower.getPosition().getDirection());
	}
}
