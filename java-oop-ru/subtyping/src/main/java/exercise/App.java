package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        Map<String, String> storage = data.toMap();
        Set<Map.Entry<String, String>> entries = storage.entrySet();
        entries.forEach(entry -> data.unset(entry.getKey()));
        entries.forEach(entry -> data.set(entry.getValue(), entry.getKey()));
    }
}
// END
