package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private TagInterface tag;
    private String textTag;

    public LabelTag(String textTag, TagInterface tag) {
        this.tag = tag;
        this.textTag = textTag;
    }

    @Override
    public String render() {
        return String.format("<label>%s%s</label>", textTag, tag.render());
    }
}
// END
