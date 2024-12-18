package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        for (var entry: data.entrySet()) {
            data.set(entry.getValue(), entry.getKey());
            data.unset(entry.getKey());
        }
    }
}
// END
