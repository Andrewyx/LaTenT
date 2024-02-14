package ui;

import model.Catalogue;
import model.Entry;
import org.scilab.forge.jlatexmath.ParseException;

import java.util.ArrayList;
import java.util.Map;

/**
 * Class for displaying all the entries in the catalogue saved so far
 */
public class EntryViewer extends Widget {

    public EntryViewer() {
        super();
        this.runWidget();
    }

    public EntryViewer(Catalogue catalogue) {
        super();
        this.findOneEntry(catalogue);
    }

    /**
     * EFFECTS: Runs the display widget's main process
     */
    @Override
    protected void runWidget() {
        this.displayAllEntries();
    }

    /**
     * EFFECTS: Displays the contents of the entire catalogue
     */
    private void displayAllEntries() {
        Catalogue catalogue = LaTenTApp.getCatalogue();
        if (catalogue.isEmpty()) {
            System.out.println("Catalogue is empty, nothing to show here");
        } else {
            for (Map.Entry<String, Entry> entry: catalogue.getCatalogue().entrySet()) {
                System.out.println("\n");
                displayEntry(entry.getValue());

            }
        }
    }

    /**
     * MODIFIES: Catalogue in LaTenTApp
     * EFFECTS: displays the contents of searched entry command, or gives closest matching commands if
     * exact match not found
     */
    private void findOneEntry(Catalogue catalogue) {
        System.out.println("Finding Entry");
        System.out.println("Give Entry Command");
        this.userText = this.userInput.next();
        if (catalogue.hasEntry(this.userText)) {
            this.displayEntry(catalogue.getCatalogueEntry(this.userText));
            new LaTeXRenderer(this.userText);
        } else {
            System.out.println("Entry Not Found, did you mean:");
            for (String name: this.searchByKeyword(
                    new ArrayList<Entry>(catalogue.getCatalogue().values()), this.userText)) {
                System.out.println("\t " + name);
            }
        }
    }

    /**
     * EFFECTS: Displays the details of the given entry
     */
    private void displayEntry(Entry entry) {
        System.out.println("Command Title: " + entry.getTitle());
        System.out.println("LaTeX Command: " + entry.getCommand());
        System.out.println("Description: " + entry.getDescription());
    }

}
