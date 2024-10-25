package com.tournament.golf.model;

public final class HoleScore {
    private int holeNumber;
    private int swings;

    public HoleScore(int holeNumber, int swings) {
        this.holeNumber = holeNumber;
        this.swings = swings;
    }

    public int getHoleNumber() {
        return holeNumber;
    }

    public void setHoleNumber(int holeNumber) {
        this.holeNumber = holeNumber;
    }

    public int getSwings() {
        return swings;
    }

    public void setSwings(int swings) {
        this.swings = swings;
    }
}
