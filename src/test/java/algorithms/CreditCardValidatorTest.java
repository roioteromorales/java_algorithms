package algorithms;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CreditCardValidatorTest {

    @Test
    public void testAMEX() {
        assertEquals("AMEX", CreditCardValidator.validate(378282246310005l));
        assertEquals("AMEX", CreditCardValidator.validate(371449635398431l));
        assertEquals("AMEX", CreditCardValidator.validate(378282246310005l));
    }

    @Test
    public void testInvalid() {
        assertEquals("INVALID", CreditCardValidator.validate(6176292929l));
    }

    @Test
    public void testMastercard() {
        assertEquals("MASTERCARD", CreditCardValidator.validate(5105105105105100l));
    }

    @Test
    public void testVisa() {
        assertEquals("VISA", CreditCardValidator.validate(4012888888881881l));
        assertEquals("VISA", CreditCardValidator.validate(4111111111111111l));
    }
}
