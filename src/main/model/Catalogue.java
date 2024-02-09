package model;

import org.scilab.forge.jlatexmath.TeXFormula;

import java.util.HashMap;

/**
 * Main catalogue class containing entry manipulation and log functions, list of entries
 */
public class Catalogue {

    private HashMap<String, Entry> catalogue;

    /**
     * EFFECTS: Creates new catalogue with no entries yet
     */
    public Catalogue() {
        this.catalogue = new HashMap<String, Entry>();
    }

    /**
     * REQUIRES: Entry does not exist already
     * MODIFIES: this
     * EFFECTS: Adds new entry to catalogue
     */
    public void addEntry() {
        //stub
    }

    /**
     * REQUIRES: Entry exists in catalogue
     * MODIFIES: this
     * EFFECTS: Removes entry from catalogue
     */
    public void removeEntry() {
        //stub
    }

    /**
     * REQUIRES: Entry exists in catalogue
     * MODIFIES: this
     * EFFECTS: Edits the given entry in the catalogue
     */
    public void editEntry() {
        //stub
    }

    /**
     * EFFECTS: Produces the given entry in the catalogue, or null if none found
     */
    public Entry getCatalogueEntry() {
        return null;
    }

    /**
     * EFFECTS: returns true is entry is in the catalogue
     */
    public boolean hasEntry() {
        return false;
    }

    /**
     * EFFECTS: produces the length of the catalogue
     */
    public int getCatalogueSize() {
        return 0;
    }
}
