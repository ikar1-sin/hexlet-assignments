package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        return apartments.stream()
                .sorted(Comparator.comparing(Home::getArea))
                .limit(count)
                .map(el -> el.toString())
                .toList();
    }

}
// END
