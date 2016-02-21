package com.delphes99.mowitnow;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.delphes99.mowitnow.Exception.GardenDimensionException;

public class GardenTest {
    @Test
    public void should_match_dimensions_when_new_jardin() throws GardenDimensionException {
        Garden jardin = new Garden(3, 4);
        assertEquals(jardin.getWidth(), 3);
        assertEquals(jardin.getHeight(), 4);
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
        Garden jardin = new Garden(4, 4);
        assertEquals(jardin.getMowerQueue().size(), 0);
    }

    @Test
    public void should_1_tondeuse_when_adding_tondeuse() throws GardenDimensionException {
        Garden jardin = new Garden(4, 4);
        jardin.addMower(new Mower());
        assertEquals(jardin.getMowerQueue().size(), 1);
    }
}
