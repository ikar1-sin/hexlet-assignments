package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {

    public static void save(Path pathToFile, Car car) {
        try {
            var serializedData = car.serialize().getBytes();
            var content = Files.write(pathToFile, serializedData, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static Car extract(Path pathToFile) {
        try {
            var content = Files.readString(pathToFile);
            return Car.deserialize(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
// END
