package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.delphes99.mowitnow.Exception.GardenDimensionException;

public class MowerTest {

	private static final Garden DEFAULT_GARDEN;

	static {
		try {
			DEFAULT_GARDEN = new Garden(5, 5);
		} catch (GardenDimensionException e) {
			throw new RuntimeException("Problem with Garden.new(int, int)");
		}
	}

	@Test
	public void should_have_position_when_new_mower() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 1, Direction.NORTH);
		assertNotNull(mower.getPosition());
	}

	@Test
	public void should_get_position_attributes_when_new_mower() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 1, Direction.NORTH);
		assertEquals(0, mower.getPosition().getCoordinates().getX());
		assertEquals(1, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.NORTH, mower.getPosition().getDirection());
	}

	/* Turn left */
	@Test
	public void should_west_when_north_and_turn_left() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.NORTH);
		mower.turnLeft();
		assertEquals(Direction.WEST, mower.getPosition().getDirection());
	}

	@Test
	public void should_north_when_east_and_turn_left() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.EAST);
		mower.turnLeft();
		assertEquals(Direction.NORTH, mower.getPosition().getDirection());
	}

	@Test
	public void should_east_when_south_and_turn_left() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.SOUTH);
		mower.turnLeft();
		assertEquals(Direction.EAST, mower.getPosition().getDirection());
	}

	@Test
	public void should_south_when_west_and_turn_left() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.WEST);
		mower.turnLeft();
		assertEquals(Direction.SOUTH, mower.getPosition().getDirection());
	}

	/* Turn right */
	@Test
	public void should_east_when_north_and_turn_right() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.NORTH);
		mower.turnRight();
		assertEquals(Direction.EAST, mower.getPosition().getDirection());
	}

	@Test
	public void should_south_when_east_and_turn_right() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.EAST);
		mower.turnRight();
		assertEquals(Direction.SOUTH, mower.getPosition().getDirection());
	}

	@Test
	public void should_west_when_south_and_turn_right() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.SOUTH);
		mower.turnRight();
		assertEquals(Direction.WEST, mower.getPosition().getDirection());
	}

	@Test
	public void should_north_when_west_and_turn_right() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.WEST);
		mower.turnRight();
		assertEquals(Direction.NORTH, mower.getPosition().getDirection());
	}

	/* Advance */
	@Test
	public void should_y_increase_when_advance_north() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.NORTH);
		mower.advance();
		assertEquals(0, mower.getPosition().getCoordinates().getX());
		assertEquals(1, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.NORTH, mower.getPosition().getDirection());
	}

	@Test
	public void should_x_increase_when_advance_east() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.EAST);
		mower.advance();
		assertEquals(1, mower.getPosition().getCoordinates().getX());
		assertEquals(0, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.EAST, mower.getPosition().getDirection());
	}

	@Test
	public void should_y_decrease_when_advance_south() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 1, 1, Direction.SOUTH);
		mower.advance();
		assertEquals(1, mower.getPosition().getCoordinates().getX());
		assertEquals(0, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.SOUTH, mower.getPosition().getDirection());
	}

	@Test
	public void should_x_decrease_when_advance_west() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 1, 1, Direction.WEST);
		mower.advance();
		assertEquals(0, mower.getPosition().getCoordinates().getX());
		assertEquals(1, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.WEST, mower.getPosition().getDirection());
	}

	/* Advance in the edge of the garden */

	@Test
	public void should_not_y_increase_when_advance_north_in_the_edge() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 5, Direction.NORTH);
		mower.advance();
		assertEquals(0, mower.getPosition().getCoordinates().getX());
		assertEquals(5, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.NORTH, mower.getPosition().getDirection());
	}

	@Test
	public void should_not_x_increase_when_advance_east_in_the_edge() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 5, 0, Direction.EAST);
		mower.advance();
		assertEquals(5, mower.getPosition().getCoordinates().getX());
		assertEquals(0, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.EAST, mower.getPosition().getDirection());
	}

	@Test
	public void should_not_y_decrease_when_advance_south_in_the_edge() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.SOUTH);
		mower.advance();
		assertEquals(0, mower.getPosition().getCoordinates().getX());
		assertEquals(0, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.SOUTH, mower.getPosition().getDirection());
	}

	@Test
	public void should_not_x_decrease_when_advance_west_in_the_edge() throws Exception {
		Mower mower = new Mower(DEFAULT_GARDEN, 0, 0, Direction.WEST);
		mower.advance();
		assertEquals(0, mower.getPosition().getCoordinates().getX());
		assertEquals(0, mower.getPosition().getCoordinates().getY());
		assertEquals(Direction.WEST, mower.getPosition().getDirection());
	}
}
