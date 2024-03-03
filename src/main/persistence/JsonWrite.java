package persistence;

import model.Catalogue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.JSONObject;

/**
 * Represents a writer for given catalogues to a json file
 */
public class JsonWrite {
    private String saveLocation;
    private PrintWriter writer;

    /**
     * EFFECTS: creates writer to save data at the given directory/location
     */
    public JsonWrite(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    /**
     * MODIFIES: this
     * EFFECTS: opens writer at the current saveLocation;
     * throws FileNotFoundException if file not available.
     */
    public void openFile() throws FileNotFoundException {
        writer = new PrintWriter(new File(saveLocation));
    }

    /**
     * MODIFIES: this
     * EFFECTS: writes the serialized json catalogue to the current saveLocation
     */
    public void write(Catalogue catalogue) {
        JSONObject js = new JSONObject();
        js.put("catalogue", catalogue.getCatalogue().values());
        writer.print(js.toString(4));
    }

    /**
     * MODIFIES: this
     * EFFECTS: closes the writing operation on the current file
     */
    public void closeFile() {
        writer.close();
    }
}
