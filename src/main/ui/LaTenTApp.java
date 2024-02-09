package ui;

import model.Catalogue;

import java.util.Scanner;

/**
 * Main app interface for the project. Responsible for running the app and subsequent processes
 */
public class LaTenTApp {
    private boolean appState;
    private String userInputString;
    private Catalogue catalogue;

    /**
     * EFFECTS: Starts new instance of the app and runs it, with a new catalogue
     */
    public LaTenTApp() {
        this.appState = true;
        this.userInputString = null;
        this.catalogue = new Catalogue();
        this.runApp();
    }

    /**
     * MODIFIES: this
     * EFFECTS: processes the users commands
     */
    private void runApp() {

        while (this.appState) {
            //do stub
        }
    }

    /**
     * EFFECTS: creates new entry to add to catalogue
     */
    private void newEntry() {

    }

    /**
     * EFFECTS: Displays the command info from the catalogue
     */
    private void findEntry() {

    }

    /**
     * EFFECTS:
     */
    private void openEntry() {

    }
}
