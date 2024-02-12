package ui;

import model.Catalogue;
import model.Entry;

import java.util.Scanner;

/**
 * Main app interface for the project. Responsible for running the app and subsequent processes
 */
public class LaTenTApp {
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static Catalogue catalogue = new Catalogue();
    private boolean appState;
    private String userInputString;
    private Widget activeWidget;

    /**
     * EFFECTS: Starts new instance of the app and runs it, with a new catalogue
     */
    public LaTenTApp() {
        this.appState = true;
        this.userInputString = null;
        this.runApp();
    }

    /**
     * MODIFIES: this
     * EFFECTS: processes the users commands
     */
    private void runApp() {
        System.out.println(Graphics.LOGO);
        System.out.println("Welcome to LaTent");
        while (this.appState) {
            System.out.println("Enter your command...");
            this.showCommandOptions();
            this.userInputString = USER_INPUT.next().toLowerCase();
            System.out.println("Running: " + this.userInputString);
            this.handleInput(userInputString);
        }
    }

    /**
     * REQUIRES: input can not be null
     * MODIFIES: this
     * EFFECTS: reads and processes user input
     */
    private void handleInput(String input) {
        switch (input) {
            case Constants.CREATE_ENTRY:
                this.newEntry();
                break;
            case Constants.FIND_ENTRY:
                System.out.println("Finding Entry");
                this.findEntry();
                break;
            case Constants.OPEN_ENTRY:
                System.out.println("Editing Entry");
                this.openEntry();
                break;
            case Constants.QUIT:
                System.out.println("Quitting");
                this.appState = false;
                break;
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: opens entry creator menu
     */
    private void newEntry() {
        System.out.println("Opening Entry Creator");
        this.activeWidget = new EntryCreator();
    }

    /**
     * EFFECTS: Displays the command info from the catalogue
     */
    private void findEntry() {
        System.out.println("Give Entry Command");
        userInputString = USER_INPUT.next();
        if (catalogue.hasEntry(userInputString)) {
            Entry activeEntry = catalogue.getCatalogueEntry(userInputString);
            System.out.println("Command Title: " + activeEntry.getTitle());
            System.out.println("LaTeX Command: " + activeEntry.getCommand());
            System.out.println("Description: " + activeEntry.getDescription());

        } else {
            System.out.println("Entry Not Found");
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: Opens the given entry in the activeWidget
     */
    private void openEntry() {
        System.out.println("Give Entry Command to Open");
        userInputString = USER_INPUT.next();
        if (catalogue.hasEntry(userInputString)) {
            this.activeWidget = new EntryEditor(
                    catalogue.getCatalogueEntry(userInputString)
            );
        } else {
            System.out.println("Entry not found");
        }
    }

    /**
     * EFFECTS: gets the current catalogue
     */
    public static Catalogue getCatalogue() {
        return catalogue;
    }

    /**
     * EFFECTS: shows the main app commands
     */
    private void showCommandOptions() {
        System.out.println("<Create Entry> | " + Constants.CREATE_ENTRY);
        System.out.println("<Find Entry> | " + Constants.FIND_ENTRY);
        System.out.println("<Open Entry> | " + Constants.OPEN_ENTRY);
        System.out.println("<Quit App> | " + Constants.QUIT);
    }
}
