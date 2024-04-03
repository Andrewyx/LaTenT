package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Event class
 */
public class EventTest {
    private Event e;
    private Event e2;
    private Date d;
    private String description = "Added Arrow to catalogue";

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event(description);   // (1)
        e2 = new Event("Different");   // (1)
        d = Calendar.getInstance().getTime();   // (2)
    }

    @Test
    public void testEvent() {
        assertEquals("Added Arrow to catalogue", e.getDescription());
        assertEquals(d, e.getDate());
    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Added Arrow to catalogue", e.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(13 * e.getDate().hashCode() + description.hashCode(),
                e.hashCode());
    }

    @Test
    public void testEquals() {
        Event e3 = null;
        assertFalse(e.equals(d));
        assertFalse(e.equals(e3));
        assertTrue(e.equals(e));
        assertFalse(e.equals(e2));
    }
}
