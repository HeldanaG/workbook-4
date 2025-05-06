package com.pluralsight;

public class Room {

    // Fields to represent room state
    private int numBed;         // Number of beds in the room
    private double price;       // Price per night
    private boolean isOccupied; // Whether the room is currently occupied
    private boolean isDirty;    // Whether the room needs cleaning

    // Constructor to initialize the room's attributes
    public Room(int numBed, double price, boolean isOccupied, boolean isDirty) {
        this.numBed = numBed;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    // Getter for number of beds
    public int getNumBed() {
        return this.numBed;
    }

    // Getter for room cleanliness status
    public boolean isDirty() {
        return this.isDirty;
    }

    // Getter for occupancy status
    public boolean isOccupied() {
        return this.isOccupied;
    }

    // Getter for room price
    public double getPrice() {
        return this.price;
    }

    // Check if the room is available for a new guest
    // A room is available only if it is not dirty and not occupied
    public boolean isAvailable() {
        return !(this.isDirty && this.isOccupied);
    }

    // Method to check a guest into the room
    // Sets the room as occupied and dirty
    public void checkIn() {
        if (!isAvailable()) {
            System.out.println("Room is not available for check-in.");
            return;
        }
        isOccupied = true;
        isDirty = true;
        System.out.println("Guest checked in.");
    }

    // Method to check a guest out of the room
    // Marks the room as unoccupied, but still dirty
    public void checkOut() {
        if (!isOccupied) {
            System.out.println("Room is already vacant.");
            return;
        }
        isOccupied = false;
        System.out.println("Guest checked out. Room now needs cleaning.");
    }

    // Method to clean the room
    // Marks the room as clean
    public void cleanRoom() {
        if (!isDirty) {
            System.out.println("Room is already clean.");
            return;
        }
        isDirty = false;
        System.out.println("Room has been cleaned.");
    }
}
