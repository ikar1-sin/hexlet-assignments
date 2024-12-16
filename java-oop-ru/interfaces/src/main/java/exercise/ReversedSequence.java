package exercise;

// BEGIN

public class ReversedSequence implements CharSequence {
    private final String str;

    ReversedSequence(String str) {
        this.str = new StringBuilder(str).reverse().toString();
    }

    @Override
    public String toString() {
        return str;
    }

    @Override
    public int length() {
        return str.length();
    }
    @Override
    public char charAt(int index) {
        return str.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return str.subSequence(start, end);
    }

}
// END
