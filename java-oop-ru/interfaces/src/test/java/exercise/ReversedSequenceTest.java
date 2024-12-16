package exercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

public class ReversedSequenceTest {
    private static ReversedSequence str;

    @BeforeAll
    public static void beforeAll() {
        str = new ReversedSequence("abcd");
    }

    @Test
    public void charAtTest() {
        var expected = 'c';
        var actual = str.charAt(1);
        assertEquals(expected, actual);
    }

    @Test
    public void lengthTest() {
        var expected = 4;
        var actual = str.length();
        assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        var expected = "dcba";
        var actual = str.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void subSequenceTest() {
        var expected = "dc";
        var actual = str.subSequence(0, 2);
        assertEquals(expected, actual);
    }
}
