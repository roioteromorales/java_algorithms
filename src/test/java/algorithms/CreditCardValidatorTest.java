package algorithms;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CreditCardValidatorTest {

    @Test
    public void testAMEX() {
        assertEquals(CreditCardValidator.validate(378282246310005l), "AMEX");
        assertEquals(CreditCardValidator.validate(371449635398431l), "AMEX");
        assertEquals(CreditCardValidator.validate(378282246310005l), "AMEX");
    }

    @Test
    public void testInvalid() {
        assertEquals(CreditCardValidator.validate(6176292929l), "INVALID");
    }

    @Test
    public void testMastercard() {
        assertEquals(CreditCardValidator.validate(5105105105105100l), "MASTERCARD");
    }

    @Test
    public void testVisa() {
        assertEquals(CreditCardValidator.validate(4012888888881881l), "VISA");
        assertEquals(CreditCardValidator.validate(4111111111111111l), "VISA");
    }
}
