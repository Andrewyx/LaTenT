package persistence;

import model.Catalogue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cites https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */
class JsonWriteTest extends JsonParseTest {
    private JsonWrite js1;
    private JsonWrite js2;
    private JsonWrite js3;

    @BeforeEach
    public void setup() {
        js1 = new JsonWrite("data/testJSONWriteEmptyCatalogue.json");
        js2 = new JsonWrite("data/testJSONWritePopulatedCatalogue.json");
        js3 = new JsonWrite("data/\tsome:d09_-file.json");
    }

    @Test
    public void testIllegalFilePath() {
        try {
            js3.openFile();
            fail("File path was illegal, should not have been accepted");
        } catch (IOException e) {
        }
    }

    @Test
    public void testWriteEmptyFile() {
        try {
            js1.openFile();
            js1.write(new Catalogue());
            js1.closeFile();

            JsonRead jr1 = new JsonRead("data/testJSONWriteEmptyCatalogue.json");
            Catalogue c = jr1.read();
            assertEquals(0, c.getCatalogueSize());
        } catch (IOException e) {
            fail("No exception expected");
        }
    }

    @Test
    public void testWritePopulatedFile() {
        Catalogue c2 = new Catalogue();
        c2.addEntry(e1);
        c2.addEntry(e2);
        try {
            js2.openFile();
            js2.write(c2);
            js2.closeFile();

            JsonRead jr2 = new JsonRead("data/testJSONWritePopulatedCatalogue.json");
            Catalogue c = jr2.read();
            assertEquals(2, c.getCatalogueSize());
            testEntry("Blue Text",
                    "name in blue text",
                    "\\textcolor{blue}{myname}",
                    c.getCatalogueEntry("\\textcolor{blue}{myname}")
            );
            testEntry("Integral",
                    "is an integral",
                    "\\int_{a}^{b}{h(x)dx}",
                    c.getCatalogueEntry("\\int_{a}^{b}{h(x)dx}")
            );
        } catch (IOException e) {
            fail("No exception expected");
        }
    }


}