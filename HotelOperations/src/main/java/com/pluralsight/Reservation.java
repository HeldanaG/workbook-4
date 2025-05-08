package com.pluralsight;

public class Reservation {

    // Fields to represent reservation details
    private String roomType;         // Type of room: "king" or "double"
    private double price;            // Price per night (based on room type)
    private int numberOfNights;      // Number of nights the guest will stay
    private boolean isWeekend;       // Whether the stay includes a weekend

    // Constructor: initializes the reservation with room type, nights, and weekend flag
    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        setRoomType(roomType);  // Automatically sets price based on room type
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    // Getter for room type
    public String getRoomType() {
        return roomType;
    }

    // Setter for room type (also sets the base price depending on type)
    public void setRoomType(String roomType) {
        this.roomType = roomType.toLowerCase();

        if (roomType.equalsIgnoreCase("king")) {
            this.price = 139.00;
        } else if (roomType.equalsIgnoreCase("double")) {
            this.price = 124.00;
        } else {
            this.price = 0; // Default fallback for unknown room types
        }
    }

    // Getter for price per night (after applying room type)
    public double getPrice() {
        return price;
    }

    // Getter for number of nights
    public int getNumberOfNights() {
        return numberOfNights;
    }

    // Setter for number of nights
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    // Getter to check if it's a weekend stay
    public boolean isWeekend() {
        return isWeekend;
    }

    // Setter to define if the stay includes a weekend
    // Also triggers a price re-evaluation
    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
        setRoomType(this.roomType);  // Reapply roomType to recalculate price
    }

    // Method to calculate total cost of the reservation
    public double getReservationTotal() {
        double nightlyRate = this.getPrice(); // or just getPrice();

        if (this.isWeekend) {
            nightlyRate *= 1.10; // Apply 10% surcharge per night
        }

        return nightlyRate * this.numberOfNights;
    }
}
