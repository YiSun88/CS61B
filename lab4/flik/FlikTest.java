package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void testFilkRandomNumber() {
        int x = 128;
        Integer a = Integer.valueOf(x);
        boolean testCondition = a instanceof Integer;
        assertTrue(testCondition);
    }
}
