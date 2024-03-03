package persistence;

import model.Catalogue;
import model.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

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
    public Catalogue read() throws IOException {
        String text = readFile();
        return parseJsonToCatalogue(new JSONObject(text));
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
     * EFFECTS: returns the current file path of reader
     */
    public String getFilePath() {
        return this.filePath.toString();
    }

    /**
     * EFFECTS: parses and returns catalogue from the json at the current file path
     */
    private Catalogue parseJsonToCatalogue(JSONObject jsonObject) {
        Catalogue catalogue = new Catalogue();
        addEntries(catalogue, jsonObject);
        return catalogue;
    }

    /**
     * MODIFIES: catalogue
     * EFFECTS: adds the entries in the json to the catalogue
     */
    private void addEntries(Catalogue catalogue, JSONObject jsonObject) {
        JSONArray array = jsonObject.getJSONArray("catalogue");
        for (Object obj: array) {
            JSONObject newjson = (JSONObject) obj;
            addEntry(catalogue, newjson);
        }
    }

    /**
     * MODIFIES: catalogue
     * EFFECTS: parses the entry from the json and adds it to the catalogue
     */
    private void addEntry(Catalogue catalogue, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String description = jsonObject.getString("description");
        String command = jsonObject.getString("command");
        catalogue.addEntry(new Entry(title, description, command));
    }

}
