package persistence;

import model.Catalogue;
import model.Entry;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Cites https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
 */
public class JsonParseTest {
    
    protected Entry e1 = new Entry("Blue Text",
            "name in blue text",
            "\\textcolor{blue}{myname}");
    protected Entry e2 = new Entry("Integral",
            "is an integral",
            "\\int_{a}^{b}{h(x)dx}");

    protected void testEntry(String title, String description, String command, Entry entry) {
        assertEquals(title, entry.getTitle());
        assertEquals(command, entry.getCommand());
        assertEquals(description, entry.getDescription());
    }
}
