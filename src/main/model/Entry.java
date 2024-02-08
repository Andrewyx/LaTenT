package model;

import java.util.ArrayList;

/**
 * Each instance is an entry to the catalogue and a different LaTeX command recorded
 */
public class Entry extends EntryTool {
    private String description;
    private String command;
    private String title;

    // EFFECTS: Creates new entry with name, title, and LaTex command
    public Entry(String title, String description, String command) {
        this.title = title;
        this.description = description;
        this.command = command;
    }
}
