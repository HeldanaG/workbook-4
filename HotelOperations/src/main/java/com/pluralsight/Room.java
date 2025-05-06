package com.pluralsight;

public class Room {

    private int numBed;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;



    public Room( int numBed, double price, boolean isOccupied, boolean isDirty) {
        this.numBed = numBed;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumBed() {
        return this.numBed;
    }

    public boolean isDirty() {
        return this.isDirty;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isAvailable() {
        return !(this.isDirty && this.isOccupied) ;
    }
}
