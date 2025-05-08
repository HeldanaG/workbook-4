package com.pluralsight;

import org.junit.jupiter.api.Test;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void punchTimeCard_should_addCorrectWorkedHours()
    {
        // Create a new employee with 0 initial hours
        Employee emp = new Employee("001", "Heldana", "Front Desk", 15.50, 0);

        // Simulate punching in at 9:00 AM
        emp.punchTimeCard(LocalTime.of(9, 0));

        // Simulate punching out at 5:00 PM
        emp.punchTimeCard(LocalTime.of(17, 0));


        double actual = emp.getHoursWorked();

        // Check that worked hours are correct
        assertEquals(8.0, actual);
    }

    @Test
    public void punchTimeCard_should_accumulateHoursOverMultipleSessions()
    {
        Employee emp = new Employee("002", "James", "Security", 14.00, 0);

        // First shift: 8:00 AM – 12:00 PM (4 hrs)
        emp.punchTimeCard(LocalTime.of(8, 0));
        emp.punchTimeCard(LocalTime.of(12, 0));

        // Second shift: 1:00 PM – 4:30 PM (3.5 hrs)
        emp.punchTimeCard(LocalTime.of(13, 0));
        emp.punchTimeCard(LocalTime.of(16, 30));

        // Total should be 7.5 hours
        assertEquals(7.5, emp.getHoursWorked());
    }
}
