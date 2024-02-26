package persistence;

import model.Entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParseTest {
    protected void testEntry(String title, String description, String command, Entry entry) {
        assertEquals(title, entry.getTitle());
        assertEquals(command, entry.getCommand());
        assertEquals(description, entry.getDescription());
    }
}
