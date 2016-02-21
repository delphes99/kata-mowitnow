package com.delphes99.mowitnow;

import java.util.LinkedList;
import java.util.Queue;

import com.delphes99.mowitnow.Exception.GardenDimensionException;

public class Garden {
    private int width;

    private int height;

    private Queue<Mower> mowerQueue;

    public Garden(int width, int height) throws GardenDimensionException {
        checkDimension(width, height);

        this.width = width;
        this.height = height;

        this.mowerQueue = new LinkedList<Mower>();
    }

    private void checkDimension(int width, int height) throws GardenDimensionException {
        if (width <= 0) {
            throw new GardenDimensionException("Garden width must be positive");
        }
        if (height <= 0) {
            throw new GardenDimensionException("Garden height must be positive");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void addMower(Mower mower) {
        this.mowerQueue.add(mower);
    }

    public Queue<Mower> getMowerQueue() {
        return mowerQueue;
    }
}
