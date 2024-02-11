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
        String inputText = null;
        System.out.println(Graphics.logo);
        System.out.println("Welcome to LaTent");
        while (this.appState) {
            System.out.println("Enter your command...");
            inputText = USER_INPUT.next();
            inputText = inputText.toLowerCase();

            if (inputText.equals("q")) {
                this.appState = false;
            } else {
                System.out.println("Running: " + inputText);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
        catalogue.getCatalogueEntry(userInputString);
        this.activeWidget = new EntryEditor(
                catalogue.getCatalogueEntry(userInputString)
        );
    }
}
