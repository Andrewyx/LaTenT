package persistence;

import model.Catalogue;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a reader for JSON catalogues from a json file
 */
public class JsonRead {
    private Path filePath;

    /**
     * REQUIRES: file must exist at file path
     * EFFECTS: creates a json reader targeted at the given file path
     */
    public JsonRead(String filepath) {
        this.setFilePath(filepath);
    }

    /**
     * EFFECTS: produces the catalogue read from the current filepath
     */
    public Catalogue read() {
        return null;
    }

    /**
     * EFFECTS: reads the contents of the current filePath as a string; throws IOException if unsuccessful
     */
    private String readFile() throws IOException {
        return Files.readString(this.filePath);
    }

    /**
     * MODIFIES: this
     * EFFECTS: sets the file path the given one
     */
    public void setFilePath(String filePath) {
        this.filePath = Path.of(filePath);
    }

    /**
     * EFFECTS: parses and returns catalogue from the json at the current file path
     */
    private Catalogue parseJsonToCatalogue(JSONObject jsonObject) {
        return null;
    }

    /**
     * MODIFIES: catalogue
     * EFFECTS: adds the entries in the json to the catalogue
     */
    private void addEntries(Catalogue catalogue, JSONObject jsonObject) {

    }

    /**
     * MODIFIES: catalogue
     * EFFECTS: parses the entry from the json and adds it to the catalogue
     */
    private void addEntry(Catalogue catalogue, JSONObject jsonObject) {

    }

}
