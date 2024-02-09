package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Main catalogue class containing entry manipulation and log functions
 */
public class CatalogueTest {
    private Catalogue catalogue;
    private Entry e1;
    private Entry e2;
    private Entry e3;

    @BeforeEach
    public void setup() {
        this.catalogue = new Catalogue();
        this.e1 = new Entry("left bracket", "is a left bracket", "\\left(");
        this.e2 = new Entry("right bracket", "is a right bracket", "\\right)");
        this.e3 = new Entry("new line", "breaks the line and inserts new line", "\\newline");
    }

    @Test
    public void testCatalogue() {
        assertEquals(0, this.catalogue.getCatalogueSize());
    }

    @Test
    public void testAddEntry() {
        this.catalogue.addEntry(this.e1);
        assertFalse(this.catalogue.hasEntry("\\newline"));
        assertTrue(this.catalogue.hasEntry("\\left("));
        this.catalogue.addEntry(this.e3);
        assertTrue(this.catalogue.hasEntry("\\newline"));
    }

    @Test
    public void testRemoveEntry() {
        this.catalogue.addEntry(this.e1);
        this.catalogue.addEntry(this.e2);
        this.catalogue.addEntry(this.e3);
        this.catalogue.removeEntry(this.e1.getCommand());
        assertFalse(this.catalogue.hasEntry("\\left("));
        assertTrue(this.catalogue.hasEntry("\\right)"));
        this.catalogue.removeEntry(this.e2.getCommand());
        assertFalse(this.catalogue.hasEntry("\\right)"));
    }

    @Test
    public void testGetCatalogueEntry() {
        this.catalogue.addEntry(this.e1);
        this.catalogue.addEntry(this.e2);
        this.catalogue.addEntry(this.e3);
        assertEquals(this.e1, this.catalogue.getCatalogueEntry("\\left("));
        assertEquals(this.e3, this.catalogue.getCatalogueEntry("\\newline"));
    }

    @Test
    public void testHasEntry() {
        assertFalse(this.catalogue.hasEntry("\\left("));
        this.catalogue.addEntry(this.e1);
        assertTrue(this.catalogue.hasEntry("\\left("));
        this.catalogue.addEntry(this.e2);
        assertTrue(this.catalogue.hasEntry("\\right)"));
    }

    @Test
    public void testGetCatalogueSize() {
        assertEquals(0, this.catalogue.getCatalogueSize());
        this.catalogue.addEntry(this.e1);
        assertEquals(1, this.catalogue.getCatalogueSize());
        this.catalogue.addEntry(this.e2);
        assertEquals(2, this.catalogue.getCatalogueSize());
        this.catalogue.addEntry(this.e3);
        assertEquals(3, this.catalogue.getCatalogueSize());
    }
}
