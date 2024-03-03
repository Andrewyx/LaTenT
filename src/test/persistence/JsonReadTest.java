package persistence;

import model.Catalogue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cites https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */
class JsonReadTest extends JsonParseTest {
    private JsonRead r1;
    private JsonRead r2;


    @BeforeEach
    public void setup() {
        r1 = new JsonRead("data\\testJSONReadEmptyCatalogue.json");
        r2 = new JsonRead("data\\testJSONReadPopulatedCatalogue.json");
    }

    @Test
    public void testConstructor() {
        assertEquals("data\\testJSONReadEmptyCatalogue.json", r1.getFilePath());
    }

    @Test
    public void testSetFilePath() {
        assertEquals("data\\testJSONReadEmptyCatalogue.json", r1.getFilePath());
        r1.setFilePath("data\\testJSONReadPopulatedCatalogue.json");
        assertEquals("data\\testJSONReadPopulatedCatalogue.json", r1.getFilePath());
    }

    @Test
    public void testReadInvalidPath() {
        JsonRead r3 = new JsonRead("data\\fakeDir.json");
        try {
            Catalogue c = r3.read();
            fail("Read should not have passed for non-existent file.");
        } catch (IOException e) {
            // Success
        }
    }

    @Test
    public void testReadEmptyCatalogue() {
        try {
            Catalogue c = r1.read();
            assertEquals(0, c.getCatalogueSize());
        } catch (IOException e) {
            fail("Unexpected Exception");
        }
    }

    @Test
    public void testReadPopulatedCatalogue() {
        try {
            Catalogue c = r2.read();
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
            fail("Unexpected Exception");
        }
    }
}