package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.delphes99.mowitnow.core.Direction;
import com.delphes99.mowitnow.exception.InvalidDirectionException;

public class DirectionTest {
	@Test
	public void should_have_4_directions() throws Exception {
		assertEquals(4, Direction.values().length);
	}

	/***************************** Get direction *****************************/
	@Test
	public void should_get_north_when_N() throws Exception {
		assertEquals(Direction.NORTH, Direction.getDirectionById("N"));
	}

	@Test
	public void should_get_east_when_E() throws Exception {
		assertEquals(Direction.EAST, Direction.getDirectionById("E"));
	}

	@Test
	public void should_get_south_when_S() throws Exception {
		assertEquals(Direction.SOUTH, Direction.getDirectionById("S"));
	}

	@Test
	public void should_get_west_when_W() throws Exception {
		assertEquals(Direction.WEST, Direction.getDirectionById("W"));
	}

	@Test(expected = InvalidDirectionException.class)
	public void should_throw_exception_when_direction_not_valide() throws Exception {
		Direction.getDirectionById("X");
	}

	/***************************** Right *****************************/
	@Test
	public void should_be_east_when_right_north() throws Exception {
		assertEquals(Direction.EAST, Direction.NORTH.getRight());
	}

	@Test
	public void should_be_south_when_right_east() throws Exception {
		assertEquals(Direction.SOUTH, Direction.EAST.getRight());
	}

	@Test
	public void should_be_west_when_right_south() throws Exception {
		assertEquals(Direction.WEST, Direction.SOUTH.getRight());
	}

	@Test
	public void should_be_north_when_right_west() throws Exception {
		assertEquals(Direction.NORTH, Direction.WEST.getRight());
	}

	/***************************** Left *****************************/
	@Test
	public void should_be_west_when_left_north() throws Exception {
		assertEquals(Direction.WEST, Direction.NORTH.getLeft());
	}

	@Test
	public void should_be_north_when_left_east() throws Exception {
		assertEquals(Direction.NORTH, Direction.EAST.getLeft());
	}

	@Test
	public void should_be_east_when_left_south() throws Exception {
		assertEquals(Direction.EAST, Direction.SOUTH.getLeft());
	}

	@Test
	public void should_be_south_when_left_west() throws Exception {
		assertEquals(Direction.SOUTH, Direction.WEST.getLeft());
	}
}
