package ui;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import me.xdrop.fuzzywuzzy.model.ExtractedResult;
import model.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Abstract class for all children widgets. Includes all required UI interaction related behaviours
 */
public abstract class Widget {
    protected boolean editorState;
    protected Scanner userInput;
    protected String userText = "";

    /**
     * EFFECTS: Creates new widget without active entry
     */
    public Widget() {
        this.editorState = true;
        this.userInput = new Scanner(System.in);
    }

    /**
     * MODIFIES: this
     * EFFECTS: reads the next line from the user and saves it
     */
    protected void readNextLine() {
        this.userInput.nextLine();
        this.userText = this.userInput.nextLine();
    }

    /**
     * MODIFIES: this
     * EFFECTS: reads the next input from the user and saves it
     */
    protected void readNext() {
        this.userText = this.userInput.next().toLowerCase();
    }

    /**
     * EFFECTS: Runs the main widget processes
     */
    protected abstract void runWidget();

    /**
     * EFFECTS: produces true if the user enters confirm
     */
    protected boolean confirmChoice() {
        while (true) {
            System.out.println("Type <YES> to confirm choice, or <q> to exit");
            this.userText = this.userInput.next().toLowerCase();
            if (userText.equals("yes")) {
                return true;
            } else if (userText.equals("q")) {
                return false;
            }
        }
    }

    /**
     * EFFECTS: Produces a list of partial matching fuzzy search entries given a list and keyword
     */
    protected List<String> searchByKeyword(List<Entry> entryList, String keyword) {
        List<String> keywordList = new ArrayList<>();
        for (Entry entry : entryList) {
            keywordList.add(entry.getCommand());
        }
        List<ExtractedResult> matches = FuzzySearch.extractTop(keyword, keywordList, 3);
        return  matches.stream().map(extractedResult -> extractedResult.getString()).collect(Collectors.toList());
    }
}
