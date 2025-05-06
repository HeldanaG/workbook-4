package com.pluralsight;

public class HotelOperations {
    public static void main(String[] args) {


        Room room1 = new Room(2, 139.00, false, false);
        Room room2 = new Room(1, 100.00, true, true);


        System.out.println("is room 1 available: " + room1.isAvailable());
        System.out.println("is room 2 available: " + room2.isAvailable());


        Reservation res1 = new Reservation("king", 2, false);
        Reservation res2 = new Reservation("double", 3, true);


        System.out.println("\nRoom type for reservation 1 : " + res1.getRoomType());
        System.out.println("Price per night for reservation 1: $" + res1.getPrice());
        System.out.println("Total for reservation 1: $" + res1.getReservationTotal());

        System.out.println("\nRoom type for reservation 2: " + res2.getRoomType());
        System.out.println("Price per night for reservation 2: $" + res2.getPrice());
        System.out.println("Total for reservation 2: $" + res2.getReservationTotal());


        Employee emp1 = new Employee("1111", "Heldana", "Front Desk", 17, 38);
        Employee emp2 = new Employee("2222", "James", "Security", 15.00, 45);


        System.out.println("\nEmployee ID: " + emp1.getEmployeeId());
        System.out.println("Total pay for employee 1: $" + emp1.getTotalPay());
        System.out.println("Regular hours for employee 1: " + emp1.getRegularHours());
        System.out.println("Overtime hours for employee 1: " + emp1.getOvertimeHours());

        System.out.println("\nEmployee ID: " + emp2.getEmployeeId());
        System.out.println("Total pay for employee 2: $" + emp2.getTotalPay());
        System.out.println("Regular hours for employee 2: " + emp2.getRegularHours());
        System.out.println("Overtime hours for employee 2: " + emp2.getOvertimeHours());
    }

}
