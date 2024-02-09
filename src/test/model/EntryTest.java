package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryTest {
    private Entry e1;
    private Entry e2;

    @BeforeEach
    public void setup() {
        this.e1 = new Entry("left bracket", "is a left bracket", "\\left(");
        this.e2 = new Entry("right bracket", "is a right bracket", "\\right)");
    }

    @Test
    public void testEntry() {
        assertEquals("left bracket", this.e1.getTitle());
        assertEquals("\\left(", this.e1.getCommand());
        assertEquals("is a left bracket",this.e1.getDescription());
    }

    @Test
    public void testChangeDescription() {
        this.e1.changeDescription("New Description");
        assertEquals("New Description", this.e1.getDescription());
        this.e2.changeDescription("Another Description");
        assertEquals("Another Description", this.e1.getDescription());
    }

    @Test
    public void testChangeCommand() {
        this.e1.changeCommand("New Command");
        assertEquals("New Command", this.e1.getCommand());
        this.e2.changeCommand("Another Command");
        assertEquals("Another Command", this.e1.getCommand());
    }

    @Test
    public void testChangeTitle() {
        this.e1.changeTitle("New Title");
        assertEquals("New Title", this.e1.getTitle());
        this.e2.changeTitle("Another Title");
        assertEquals("Another Title", this.e1.getTitle());
    }

    @Test
    public void testGetDescription() {
        assertEquals("is a left bracket",this.e1.getDescription());
        assertEquals("is a right bracket",this.e2.getDescription());
    }

    @Test
    public void testGetCommand() {
        assertEquals("\\left(", this.e1.getCommand());
        assertEquals("\\right)", this.e2.getCommand());
    }

    @Test
    public void testGetTitle() {
        assertEquals("left bracket", this.e1.getTitle());
        assertEquals("right bracket", this.e2.getTitle());
    }
}
