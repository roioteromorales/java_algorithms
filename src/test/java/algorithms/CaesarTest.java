package algorithms;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CaesarTest {

    @Test
    public void testNormal() {
        assertEquals(Caesar.crypt("Hello", 5), "Mjqqt");
    }

    @Test
    public void testBlank() {
        assertEquals(Caesar.crypt("", 5), "");
    }

    @Test
    public void testDash() {
        assertEquals(Caesar.crypt("H---", 2), "J---");
    }
}
