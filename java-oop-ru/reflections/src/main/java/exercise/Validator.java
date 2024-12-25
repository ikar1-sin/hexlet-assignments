package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
// BEGIN
public class Validator {
    public static List<String> validate(Address ad) {
        var validatedData = new ArrayList<String>();
        Class<?> adClass = ad.getClass();
        var fields = adClass.getDeclaredFields();
        try {
            for (var field: fields) {
                field.setAccessible(true);
                var obj = field.get(ad);
                if (field.isAnnotationPresent(NotNull.class) && obj == null) {
                    validatedData.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.getMessage();
        }

        return validatedData;
    }

    public static Map<String, List<String>> advancedValidate(Address ad) {
        var validatedMap = new HashMap<String, List<String>>();
        var adClass = ad.getClass();
        Field[] fields = adClass.getDeclaredFields();

        try {
            for (var field: fields) {
                field.setAccessible(true);
                var obj = field.get(ad);

                if (field.isAnnotationPresent(NotNull.class) && obj == null) {
                    validatedMap.put(field.getName(), List.of("can not be null"));
                } else if (field.isAnnotationPresent(MinLength.class) && obj.toString().length() > 4) {
                    List<String> temp = validatedMap.getOrDefault(field.getName(), new ArrayList<>());
                    temp.add("length less than 4");
                    validatedMap.put(field.getName(), temp);
                }
            }
        } catch (IllegalAccessException ex) {
            ex.getMessage();
        }
        return validatedMap;
    }
}
// END
