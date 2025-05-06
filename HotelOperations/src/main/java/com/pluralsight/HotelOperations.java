package com.pluralsight;

public class HotelOperations {
    public static void main(String[] args) {


        Room room1 = new Room(2, 139.00, false, false);
        Room room2 = new Room(1, 100.00, true, true);


        System.out.println("is room 1 available: " + room1.isAvailable());
        System.out.println("is room 2 available: " + room2.isAvailable());

    }

}
