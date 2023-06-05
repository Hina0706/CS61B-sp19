import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    @Test
    public void testOffByN(){
        OffByN offBy5 = new OffByN(5);
        boolean expected1 = offBy5.equalChars('a', 'f');
        boolean expected2 = offBy5.equalChars('f', 'a');
        boolean expected3 = offBy5.equalChars('f', 'h');
        assertTrue(expected1);
        assertTrue(expected2);
        assertFalse(expected3);
    }
}
