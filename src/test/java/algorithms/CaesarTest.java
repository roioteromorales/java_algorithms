package algorithms;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CaesarTest {

    @Test
    public void testNormal() {
        assertEquals("Mjqqt", Caesar.crypt("Hello", 5));
    }

    @Test
    public void testBlank() {
        assertEquals("", Caesar.crypt("", 5));
    }

    @Test
    public void testDash() {
        assertEquals("J---", Caesar.crypt("H---", 2));
    }
}
