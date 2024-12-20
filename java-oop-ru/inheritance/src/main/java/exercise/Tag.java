package exercise;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.LinkedHashMap;

// BEGIN
public abstract class Tag {
    protected final String tagName;
    protected final Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = new LinkedHashMap<>(attributes);
    }

    public String getTagName() {
        return tagName;
    }

    public List<Entry<String,String>> getAttributes() {
        return attributes.entrySet()
                .stream()
                .toList();
    }

    public int getAttributesSize() {
        return attributes.size();
    }

    public String createTag() {
        String formattedString = String.format("<%s", getTagName());
        for (int i = 0; i < getAttributesSize(); i++) {
            formattedString += String.format(" %s=\"%s\"",
                    getAttributes().get(i).getKey(),
                    getAttributes().get(i).getValue()
            );
        }
        return formattedString + ">";
    }

    public abstract String toString();
}
// END
