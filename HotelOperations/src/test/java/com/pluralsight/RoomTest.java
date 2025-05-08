package com.pluralsight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {

    // -------------------- checkIn() Tests --------------------

    @Test
    public void checkIn_should_setRoomAsOccupiedAndDirty()
    {
        Room room = new Room(2, 139.00, false, false);
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkIn_should_notCheckInIfRoomIsOccupied()
    {
        Room room = new Room(2, 139.00, true, false); // already occupied
        room.checkIn();  // should not allow check-in
        assertTrue(room.isOccupied());
    }

    @Test
    public void checkIn_should_notCheckInIfRoomIsDirty()
    {
        Room room = new Room(2, 139.00, false, true); // dirty but not occupied
        room.checkIn(); // should not allow check-in
        assertFalse(room.isOccupied()); // check-in should not change this
    }

    // -------------------- checkOut() Tests --------------------

    @Test
    public void checkOut_should_setRoomAsUnoccupiedAndClean()
    {
        Room room = new Room(2, 139.00, true, true); // occupied and dirty
        room.checkOut();
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }

    @Test
    public void checkOut_should_doNothingIfRoomIsAlreadyVacant()
    {
        Room room = new Room(2, 139.00, false, false); // already vacant
        room.checkOut();
        assertFalse(room.isOccupied());
    }

    // -------------------- cleanRoom() Tests --------------------

    @Test
    public void cleanRoom_should_setRoomAsClean()
    {
        Room room = new Room(2, 139.00, true, true);
        room.cleanRoom();
        assertFalse(room.isDirty());
    }

    @Test
    public void cleanRoom_should_doNothingIfAlreadyClean()
    {
        Room room = new Room(2, 139.00, false, false);
        room.cleanRoom();
        assertFalse(room.isDirty());
    }
}
