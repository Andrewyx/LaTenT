package ui;

import model.Catalogue;
import persistence.JsonRead;
import persistence.JsonWrite;
import ui.console.EntryCreator;
import ui.console.EntryEditor;
import ui.console.EntryViewer;
import ui.swing.LaTenTWindow;
import ui.util.Constants;
import ui.util.Graphics;
import ui.util.Widget;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main app interface for the project. Responsible for running the app and subsequent subprocesses.
 * Instantiating this class starts up the application.
 */
public class LaTenTApp {
    private static final Scanner USER_INPUT = new Scanner(System.in);
    private static Catalogue catalogue = new Catalogue();
    private boolean appState;
    private String userInputString;
    private Widget activeWidget;
    private LaTenTWindow appWindow;

    /**
     * EFFECTS: Starts new instance of the app and runs it, with a new catalogue
     */
    public LaTenTApp() {
        this.appState = true;
        USER_INPUT.useDelimiter("\n");
        this.userInputString = null;
        this.initWindow();
        this.runApp();
    }

    /**
     * MODIFIES: this
     * EFFECTS: starts main app window
     */
    private void initWindow() {
        this.appWindow = new LaTenTWindow();
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
                this.findEntry();
                break;
            case Constants.OPEN_ENTRY:
                this.openEntry();
                break;
            case Constants.SHOW_ALL:
                this.showAllEntries();
                break;
            case Constants.SAVE_CATALOGUE:
                saveCatalogue();
                break;
            case Constants.LOAD_CATALOGUE:
                loadCatalogue();
                break;
            case Constants.QUIT:
                this.terminateApp();
                break;
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: stops and quits the app
     */
    private void terminateApp() {
        System.out.println("Quitting");
        this.appState = false;
    }

    /**
     * MODIFIES: Data
     * EFFECTS: Saves the current catalogue to the disk
     */
    public static void saveCatalogue() {
        try {
            JsonWrite writer = new JsonWrite("data/catalogue.json");
            writer.openFile();
            writer.write(catalogue);
            writer.closeFile();
        } catch (FileNotFoundException e) {
            System.out.println("There was an error saving the log");
            e.printStackTrace();
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: Loads the existing disk catalogue into the current app
     */
    public static void loadCatalogue() {
        try {
            JsonRead reader = new JsonRead("data/catalogue.json");
            catalogue = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
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
     * EFFECTS: Displays a specific command info from the catalogue through the find menu
     */
    private void findEntry() {
        this.activeWidget = new EntryViewer(catalogue);
    }

    /**
     * MODIFIES: this
     * EFFECTS: Opens the given entry in the activeWidget
     */
    private void openEntry() {
        System.out.println("Editing Entry");
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
     * EFFECTS: Shows all the entries in the catalogue
     */
    private void showAllEntries() {
        System.out.println("Showing all entries: ");
        this.activeWidget = new EntryViewer();
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
        System.out.println("\t <Create Entry> " + Constants.CREATE_ENTRY);
        System.out.println("\t <Find Entry> " + Constants.FIND_ENTRY);
        System.out.println("\t <Open Entry> " + Constants.OPEN_ENTRY);
        System.out.println("\t <Show All Entries> " + Constants.SHOW_ALL);
        System.out.println("\t <Load Logs From Disk> " + Constants.LOAD_CATALOGUE);
        System.out.println("\t <Save Logs to Disk> " + Constants.SAVE_CATALOGUE);
        System.out.println("\t <Quit App> " + Constants.QUIT);
    }
}
