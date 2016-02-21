package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.delphes99.mowitnow.core.Direction;
import com.delphes99.mowitnow.core.Garden;
import com.delphes99.mowitnow.core.Mower;
import com.delphes99.mowitnow.exception.GardenDimensionException;

public class GardenTest {
	@Test
	public void should_match_dimensions_when_new_garden() throws Exception {
		Garden garden = new Garden(3, 4);
		assertEquals(garden.getWidth(), 3);
		assertEquals(garden.getHeight(), 4);
	}

	@Test(expected = GardenDimensionException.class)
	public void should_throw_exception_when_width_null() throws Exception {
		new Garden(0, 4);
	}

	@Test(expected = GardenDimensionException.class)
	public void should_throw_exception_when_height_null() throws Exception {
		new Garden(4, 0);
	}

	@Test
	public void should_not_have_mower_when_new_garden() throws Exception {
		Garden garden = new Garden(4, 4);
		assertEquals(garden.getNumberOfMowers(), 0);
	}

	@Test
	public void should_1_mower_when_adding_mower() throws Exception {
		Garden garden = new Garden(4, 4);
		garden.addMower(new Mower(garden, 0, 0, Direction.NORTH));
		assertEquals(garden.getNumberOfMowers(), 1);
	}
}
