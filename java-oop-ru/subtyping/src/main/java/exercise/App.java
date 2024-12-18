package exercise;

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
