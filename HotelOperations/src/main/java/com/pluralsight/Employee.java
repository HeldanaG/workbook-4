package com.pluralsight;

import java.time.Duration;
import java.time.LocalTime;

public class Employee {

    // Fields to store employee information
    private String employeeId;       // Unique ID for the employee
    private String name;             // Employee name
    private String department;       // Department where the employee works
    private double payRate;          // Hourly pay rate
    private double hoursWorked;      // Total hours worked
    private LocalTime punchInTime = null; // Time when employee last punched in

    // Constructor to initialize all employee details
    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    // Method to handle both punch-in and punch-out using LocalTime
    public void punchTimeCard(LocalTime time) {
        if (punchInTime == null) {
            // If no punch-in yet, this call acts as punch-in
            punchInTime = time;
            System.out.println(name + " punched in at " + punchInTime);
        } else {
            // If already punched in, this call acts as punch-out
            Duration duration = Duration.between(punchInTime, time);
            double hours = duration.toMinutes() / 60.0;  // Convert minutes to decimal hours
            hoursWorked += hours;
            System.out.printf("%s punched out at %s \n(Worked %.2f hrs)%n", name, time, hours);
            punchInTime = null;
        }
    }

    // Overloaded method to use the current system time
        public void punchTimeCard() {
            // Use only hour and minute from LocalTime.now()
            int hour = LocalTime.now().getHour();
            int minute = LocalTime.now().getMinute();
            LocalTime currentTime = LocalTime.of(hour, minute);

            // Use simplified output time without nanoseconds
            if (punchInTime == null) {
                punchInTime = currentTime;
                System.out.println(name + " punched in at " + punchInTime);
            } else {
                Duration duration = Duration.between(punchInTime, currentTime);
                double hours = duration.toMinutes() / 60.0;
                hoursWorked += hours;
                System.out.printf("%s punched out at %s (Worked %.2f hrs)%n", name, currentTime, hours);
                punchInTime = null;
            }
        }


        // Getter for regular hours (up to 40 max)
    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    // Getter for overtime hours (any hours over 40)
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // Getter for total pay (regular + 1.5x overtime)
    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    // Standard getters and setters below

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
