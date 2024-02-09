package model;


/**
 * Each instance is an entry to the catalogue and a different LaTeX command recorded
 */
public class Entry implements MutationTools {
    private String description;
    private String command;
    private String title;

    /**
     * EFFECTS: Creates new entry with name, title, and LaTex command
     */
    public Entry(String title, String description, String command) {
        this.title = title;
        this.description = description;
        this.command = command;
    }

    /**
     * REQUIRES:
     * MODIFIES: this
     * EFFECTS: changes the description of the entry to the given string
     */
    @Override
    public void changeDescription(String description) {

    }

    /**
     * REQUIRES:
     * MODIFIES: this
     * EFFECTS: changes the command of the entry to the given string
     */
    @Override
    public void changeCommand(String command) {

    }

    /**
     * REQUIRES:
     * MODIFIES: this
     * EFFECTS: changes the title of the entry to the given string
     */
    @Override
    public void changeTitle(String title) {

    }

    public String getDescription() {
        return null;
    }

    public String getCommand() {
        return null;
    }

    public String getTitle() {
        return null;
    }
}
