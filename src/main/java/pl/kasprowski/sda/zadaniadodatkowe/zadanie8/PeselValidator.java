package pl.kasprowski.sda.zadaniadodatkowe.zadanie8;

import java.util.Arrays;

public class PeselValidator {
    int[] multipliers = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};

    /**
     * Validate pesel number
     *
     * @param pesel long
     * @return boolean, true if pesel is correct
     */
    public boolean isValid(Long pesel) {
        String longString = Long.toString(pesel);
        if (longString.length() != 11) {
            throw new RuntimeException("Błędne dane!");
        }
        int[] result = new int[11];

        for (int i = 0; i < multipliers.length; i++) {
            result[i] = multipliers[i] * Character.getNumericValue(longString.charAt(i));
        }
        int sum = Arrays.stream(result).sum();
        if (sum < 0) {
            return false;
        } else if (sum % 10 != 0) {
            return false;
        } else {
            return true;
        }
    }


}
