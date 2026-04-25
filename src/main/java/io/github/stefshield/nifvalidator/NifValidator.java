package io.github.stefshield.nifvalidator;

public class NifValidator {

    /**
     * Validates a Portuguese NIF (Número de Identificação Fiscal).
     * Checks format, digit-only content, and the official check digit algorithm.
     *
     * @param nif the 9-digit tax identification number to validate
     * @return {@code true} if the NIF is mathematically valid, {@code false} otherwise
     * @author hstefanov1
     */
    public static boolean isNif(String nif) {
        if (nif == null || nif.length() != 9 || !nif.chars().allMatch(Character::isDigit)) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += (nif.charAt(i) - '0') * (9 - i);
        }

        int checkDigit = 11 - (sum % 11);
        if (checkDigit >= 10) {
            checkDigit = 0;
        }

        return checkDigit == (nif.charAt(8) - '0');
    }
}
