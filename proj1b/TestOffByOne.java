import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        char k1 = 'u';
        char k2 = 'm';
        boolean expected = offByOne.equalChars(k1, k2);
        assertFalse(expected);
    }
}

