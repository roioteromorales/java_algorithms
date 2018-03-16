package algorithms;

public class CreditCardValidator {

    public static void main(String[] args) {

        System.out.println("Test: " + validate(378282246310005l));    // Output: AMEX
        System.out.println("Test: " + validate(6176292929l));         // Output: INVALID
        System.out.println("Test: " + validate(371449635398431l));    // Output: AMEX
        System.out.println("Test: " + validate(378734493671000l));    // Output: AMEX
        System.out.println("Test: " + validate(5105105105105100l));   // Output: MASTERCARD
        System.out.println("Test: " + validate(4012888888881881l));   // Output: VISA
        System.out.println("Test: " + validate(4111111111111111l));   // Output: VISA

    }


    /**
     * Determines whether a given Credit Card Number is valid
     * @param cc_number as a long with no dashes
     * @return a boolean whether the Credit Card Number is valid
     */
    public static String validate(long cc_number) {

        // ensure correct # of digits
        int digits = (int)Math.ceil(Math.log10(cc_number));
        if (digits < 13 || digits > 16) { return "INVALID"; }

        // ensure luhn's algorithm passes
        if (!luhnAlgorithm(cc_number)) { return "INVALID"; }

        // determine card type
        int two_digits = (int)(cc_number / Math.pow(10, digits - 2));

        if (two_digits == 34 || two_digits == 37)
        {
            return "AMEX";
        }
        else if (two_digits > 50 && two_digits <= 55)
        {
            return "MASTERCARD";
        }
        else if (two_digits / 10 == 4)
        {
            return "VISA";
        }

        return "INVALID";
    }

    /**
     * Determines whether the given Credit Card Number passes Luhn's Algorithm
     * @param cc_number as a long with no dashes
     * @return a boolean whether the Credit Card Number passes Luhn's Algorithm
     */
    private static boolean luhnAlgorithm(long cc_number) {
        long num = cc_number;
        int count = 0;
        int sum = 0;

        // iterate backwards through the digits
        while (num != 0) {
            // get last digit remaining
            int digit = (int)(num % 10);

            // if the digit is even add it to sum
            if(count % 2 == 0) {
                sum += digit;
            }
            // if the digit is odd add twice the digit to sum
            else
            {
                digit *= 2;

                // wrap digits
                if (digit > 9)
                {
                    digit = 1 + (digit - 10);
                }

                sum += digit;
            }

            // iterate one digit left
            count += 1;
            num /= 10;
        }

        // if the sum is even, Luhn's Algorithm passes
        if (sum % 2 == 0) {
            return true;
        }

        return false;
    }
}
