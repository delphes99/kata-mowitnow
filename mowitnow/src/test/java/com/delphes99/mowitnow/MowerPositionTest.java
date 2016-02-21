package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MowerPositionTest {
	@Test
	public void should_get_attribute_when_new_position() throws Exception {
		MowerPosition position = new MowerPosition(0, 1, Direction.NORTH);

		assertEquals(0, position.getX());
		assertEquals(1, position.getY());
		assertEquals(Direction.NORTH, position.getDirection());
	}
}
