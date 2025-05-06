package com.pluralsight;

import java.time.LocalTime;

public class HotelOperations {
    public static void main(String[] args) {

        // ------------------ ROOM TESTING ------------------

        // Create two Room objects with initial states
        Room room1 = new Room(2, 139.00, false, false);  // 2 beds, available, clean
        Room room2 = new Room(1, 100.00, true, true);    // 1 bed, occupied, dirty

        // Check and display availability of each room
        System.out.println("is room 1 available: " + room1.isAvailable());
        System.out.println("is room 2 available: " + room2.isAvailable());

        // ------------------ RESERVATION TESTING ------------------

        System.out.println("\nReservation---------------------------------------------------------------------");

        // Create two Reservation objects with different room types and durations
        Reservation res1 = new Reservation("king", 2, false);   // Not a weekend stay
        Reservation res2 = new Reservation("double", 3, true);  // Weekend stay

        // Print reservation details for res1
        System.out.println("Room type for reservation 1 : " + res1.getRoomType());
        System.out.println("Booked number of nights for reservation 1 : " + res1.getNumberOfNights());
        System.out.println("Is weekend included  for reservation 1 : " + res1.isWeekend());
        System.out.println("Price per night for reservation 1: $" + res1.getPrice());
        System.out.printf("Total for reservation 1: $%.2f", res1.getReservationTotal());

        // Print reservation details for res2
        System.out.println("\n\nRoom type for reservation 2: " + res2.getRoomType());
        System.out.println("Booked number of nights for reservation 2 : " + res2.getNumberOfNights());
        System.out.println("Is weekend included  for reservation 2 : " + res2.isWeekend());
        System.out.println("Price per night for reservation 2: $" + res2.getPrice());
        System.out.printf("Total for reservation 2: $%.2f", res2.getReservationTotal());

        // ------------------ EMPLOYEE TESTING ------------------

        System.out.println("\n\nEmployee---------------------------------------------------------------------");

        // Create two Employee objects
        Employee emp1 = new Employee("1111", "Heldana", "Front Desk", 17, 0); // 0 initial hours
        Employee emp2 = new Employee("2222", "James", "Security", 15.00, 45); // Already worked 45 hours

        // Simulate punch-in and punch-out for emp1
        emp1.punchTimeCard(LocalTime.of(9, 0));   // Punch in at 9:00 AM
        emp1.punchTimeCard(LocalTime.of(17, 0));  // Punch out at 5:00 PM (8 hrs)

        // Print payroll information for employee 1
        System.out.println("\nEmployee ID: " + emp1.getEmployeeId());
        System.out.println("Employee name: " + emp1.getName());
        System.out.println("Regular hours for employee 1: " + emp1.getRegularHours());
        System.out.println("Overtime hours for employee 1: " + emp1.getOvertimeHours());
        System.out.println("Total pay for employee 1: $" + emp1.getTotalPay());

        // Print payroll information for employee 2
        System.out.println("\nEmployee ID: " + emp2.getEmployeeId());
        System.out.println("Employee name: " + emp2.getName());
        System.out.println("Regular hours for employee 2: " + emp2.getRegularHours());
        System.out.println("Overtime hours for employee 2: " + emp2.getOvertimeHours());
        System.out.println("Total pay for employee 2: $" + emp2.getTotalPay());

    }
}
