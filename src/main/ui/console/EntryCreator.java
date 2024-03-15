package ui.console;

import model.Entry;
import ui.util.Creator;
import ui.LaTenTApp;
import ui.util.Widget;

/**
 * Entry Creator widget to construct new Entries
 */
public class EntryCreator extends Widget implements Creator {
    public EntryCreator() {
        super();
        this.runWidget();
    }

    /**
     * MODIFIES: Catalogue in LaTenTApp
     * EFFECTS: Runs Entry creation widget
     */
    @Override
    protected void runWidget() {
        Entry newEntry = this.runCreateEntry();
        if (newEntry != null) {
            LaTenTApp.getCatalogue().addEntry(newEntry);
        }
    }

    /**
     *  MODIFIES: this
     *  EFFECTS: Runs the create new entry process and processes user input
     */
    @Override
    public Entry runCreateEntry() {
        String title;
        String command;
        String description;
        while (this.editorState) {
            System.out.println("Enter new Entry Title: ");
            title = this.userInput.nextLine();

            System.out.println("Enter new Entry Command: ");
            command = this.userInput.nextLine();

            System.out.println("Enter new Entry Description: ");
            description = this.userInput.nextLine();
            if (super.confirmChoice()) {
                return new Entry(title, description, command);
            }
        }
        return null;
    }
}
