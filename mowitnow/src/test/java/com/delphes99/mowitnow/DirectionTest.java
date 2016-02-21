package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionTest {
	@Test
	public void should_have_4_directions() {
		assertEquals(4, Direction.values().length);
	}

	@Test
	public void should_be_east_when_right_north() {
		assertEquals(Direction.EAST, Direction.NORTH.getRight());
	}

	@Test
	public void should_be_south_when_right_east() {
		assertEquals(Direction.SOUTH, Direction.EAST.getRight());
	}

	@Test
	public void should_be_west_when_right_south() {
		assertEquals(Direction.WEST, Direction.SOUTH.getRight());
	}

	@Test
	public void should_be_north_when_right_west() {
		assertEquals(Direction.NORTH, Direction.WEST.getRight());
	}

	@Test
	public void should_be_west_when_left_north() {
		assertEquals(Direction.WEST, Direction.NORTH.getLeft());
	}

	@Test
	public void should_be_north_when_left_east() {
		assertEquals(Direction.NORTH, Direction.EAST.getLeft());
	}

	@Test
	public void should_be_east_when_left_south() {
		assertEquals(Direction.EAST, Direction.SOUTH.getLeft());
	}

	@Test
	public void should_be_south_when_left_west() {
		assertEquals(Direction.SOUTH, Direction.WEST.getLeft());
	}
}
