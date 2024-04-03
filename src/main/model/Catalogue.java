package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Main catalogue class containing entry manipulation and log functions, list of entries.
 */
public class Catalogue {

    private Map<String, Entry> catalogue;
    private EventLog eventLog = EventLog.getInstance();

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
        eventLog.logEvent(new Event("Added entry to catalogue named " + entry.getTitle()));
    }

    /**
     * REQUIRES: Entry exists in catalogue
     * MODIFIES: this
     * EFFECTS: Removes entry from catalogue given its key
     */
    public void removeEntry(String key) {
        eventLog.logEvent(new Event("Removed entry from catalogue named "
                + this.catalogue.get(key).getTitle()));
        this.catalogue.remove(key);
    }

    /**
     * REQUIRES: Entry exists in catalogue
     * MODIFIES: this
     * EFFECTS: Removes entry from catalogue given an entry
     */
    public void removeEntry(Entry entry) {
        eventLog.logEvent(new Event("Removed entry from catalogue named "
                + entry.getTitle()));
        this.catalogue.remove(entry.getCommand());
    }

    /**
     * EFFECTS: Produces the given entry in the catalogue from its command
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

    /**
     * EFFECTS: Returns true if the catalogue is empty
     */
    public boolean isEmpty() {
        return this.getCatalogueSize() == 0;
    }

    /**
     * EFFECTS: Returns the catalogue as a whole
     */
    public Map<String, Entry> getCatalogue() {
        return this.catalogue;
    }
}
