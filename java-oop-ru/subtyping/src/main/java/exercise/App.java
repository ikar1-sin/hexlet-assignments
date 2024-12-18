package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        Set<Map.Entry<String, String>> entries = storage.entrySet();
        entries.forEach(entry -> data.unset(entry.getKey()));
        entries.forEach(entry -> data.set(entry.getValue(), entry.getKey()));
    }
}
// END
