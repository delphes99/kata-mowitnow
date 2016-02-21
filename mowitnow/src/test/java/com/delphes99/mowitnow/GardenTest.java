package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.delphes99.mowitnow.Exception.GardenDimensionException;

public class GardenTest {
	@Test
	public void should_match_dimensions_when_new_jardin() throws GardenDimensionException {
		Garden garden = new Garden(3, 4);
		assertEquals(garden.getWidth(), 3);
		assertEquals(garden.getHeight(), 4);
	}

	@Test(expected = GardenDimensionException.class)
	public void should_throw_exception_when_longueur_nulle() throws GardenDimensionException {
		new Garden(0, 4);
	}

	@Test(expected = GardenDimensionException.class)
	public void should_throw_exception_when_hauteur_nulle() throws GardenDimensionException {
		new Garden(4, 0);
	}

	@Test
	public void should_not_have_tondeuse_when_new_jardin() throws GardenDimensionException {
		Garden garden = new Garden(4, 4);
		assertEquals(garden.getMowerQueue().size(), 0);
	}

	@Test
	public void should_1_tondeuse_when_adding_tondeuse() throws GardenDimensionException {
		Garden garden = new Garden(4, 4);
		garden.addMower(new Mower(garden, 0, 0, Direction.NORTH));
		assertEquals(garden.getMowerQueue().size(), 1);
	}
}
