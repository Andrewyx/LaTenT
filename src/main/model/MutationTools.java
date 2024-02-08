package model;

/**
 * Responsible for Entry manipulations
 */
public interface MutationTools {

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: changes the description of the entry to the given string
    public void changeDescription(String description);

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: changes the command of the entry to the given string
    public void changeCommand(String command);

    // REQUIRES:
    // MODIFIES: this
    // EFFECTS: changes the title of the entry to the given string
    public void changeTitle(String title);
}
