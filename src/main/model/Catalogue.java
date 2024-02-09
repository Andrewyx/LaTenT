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
    public void addEntry(Entry entry) {
        this.catalogue.put(entry.getCommand(), entry);
    }

    /**
     * REQUIRES: Entry exists in catalogue
     * MODIFIES: this
     * EFFECTS: Removes entry from catalogue given its key
     */
    public void removeEntry(String key) {
        this.catalogue.remove(key);
    }

    /**
     * REQUIRES: Entry exists in catalogue
     * MODIFIES: this
     * EFFECTS: Removes entry from catalogue given an entry
     */
    public void removeEntry(Entry entry) {
        this.catalogue.remove(entry.getCommand());
    }

    /**
     * EFFECTS: Produces the given entry in the catalogue
     */
    public Entry getCatalogueEntry(String key) {
        return this.catalogue.get(key);
    }

    /**
     * EFFECTS: returns true is entry is in the catalogue
     */
    public boolean hasEntry(String key) {
        return this.catalogue.containsKey(key);
    }

    /**
     * EFFECTS: produces the length of the catalogue
     */
    public int getCatalogueSize() {
        return this.catalogue.size();
    }
}
