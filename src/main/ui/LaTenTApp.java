package ui;

import model.Catalogue;
import model.Entry;

import java.util.Scanner;

/**
 * Main app interface for the project. Responsible for running the app and subsequent processes
 */
public class LaTenTApp {
    private boolean appState;
    private String userInputString;
    protected Catalogue catalogue;
    private Scanner userInput;
    private EntryEditor editor;

    /**
     * EFFECTS: Starts new instance of the app and runs it, with a new catalogue
     */
    public LaTenTApp() {
        this.appState = true;
        this.userInputString = null;
        this.catalogue = new Catalogue();
        this.userInput = new Scanner(System.in);
        this.runApp();
    }

    /**
     * MODIFIES: this
     * EFFECTS: processes the users commands
     */
    private void runApp() {
        String inputText = null;
        System.out.println(
                "\n"
                        + "                               \n"
                        + " __        _____         _____ \n"
                        + "|  |   ___|_   _|___ ___|_   _|\n"
                        + "|  |__| .'| | | | -_|   | | |  \n"
                        + "|_____|__,| |_| |___|_|_| |_|  \n"
                        + "                               \n"
        );
        while (this.appState) {
            System.out.println("Welcome to LaTent");
            System.out.println("Enter your command");
            inputText = this.userInput.next();
            inputText.toString().toLowerCase();

            if (inputText.equals("q")) {
                this.appState = false;
            } else {
                System.out.println("Running: " + inputText);
                this.handleInput(inputText);
            }
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: reads and processes user input
     */
    private void handleInput(String input) {
        switch (input) {
            case "/a":
                System.out.println("Creating Entry");
                this.newEntry();
                break;
            case "/f":
                System.out.println("Finding Entry");
                this.findEntry();
                break;
            case "/o":
                System.out.println("Editing Entry");
                this.openEntry();
                break;
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: creates new entry to add to catalogue
     */
    private void newEntry() {
        System.out.println("Opening Entry Creator");
        this.editor = new EntryEditor();
        Entry createdEntry = this.editor.runCreateEntry();
        if (createdEntry != null) {
            this.catalogue.addEntry(createdEntry);
        }
    }

    /**
     * EFFECTS: Displays the command info from the catalogue
     */
    private void findEntry() {
        System.out.println("Give Entry Command");
        userInputString = this.userInput.next();
        if (this.catalogue.hasEntry(userInputString)) {
            Entry activeEntry = this.catalogue.getCatalogueEntry(userInputString);
            System.out.println(
                    activeEntry.getTitle()
                            + activeEntry.getCommand()
                            + activeEntry.getDescription()
            );
        } else {
            System.out.println("Entry Not Found");
        }
    }

    /**
     * MODIFIES: this
     * EFFECTS: Opens the given entry in the editor
     */
    private void openEntry() {
        System.out.println("Give Entry Command to Open");
        userInputString = this.userInput.next();
        this.catalogue.getCatalogueEntry(userInputString);
        this.editor = new EntryEditor();
        this.editor.runEditor(
                this.catalogue.getCatalogueEntry(userInputString)
        );
    }
}
