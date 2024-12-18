package exercise;

// BEGIN
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private String pathToFile;
    private Map<String, String> data;

    public FileKV(String pathToFile, Map<String, String> data) {
        this.pathToFile = pathToFile;
        this.data = data;
    }

    @Override
    public void set(String key, String value) {

    }
}
// END
