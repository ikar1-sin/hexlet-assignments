package exercise;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag(
            String tagName, Map<String, String> attributes,
            String tagBody, List<Tag> children
    ) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.children = new ArrayList<>(children);

    }

    @Override
    public String toString() {
        var formattedString = createTag() + tagBody;

        for (int i = 0; i < children.size(); i++) {
            formattedString += String.format("%s", children.get(i).createTag());
        }

        return String.format("%s</%s>", formattedString, getTagName());
    }

}
// END
