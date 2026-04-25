package io.github.stefshield.nifvalidator;

/**
 * Utility class for validating Portuguese NIF (Número de Identificação Fiscal).
 *
 * <p>A NIF is a 9-digit tax identification number assigned to individuals
 * and legal entities in Portugal. Validation is performed by checking the
 * format and applying the official modulo-11 check digit algorithm.</p>
 *
 * <p>This class is not instantiable; use the static method directly:</p>
 * <pre>{@code
 * boolean valid = NifValidator.isNif("123456789");
 * }</pre>
 *
 */
public class NifValidator {

    private NifValidator() {
    }

    /**
     * Validates a Portuguese NIF (Número de Identificação Fiscal).
     * Checks format, digit-only content, and the official check digit algorithm.
     *
     * @param nif the 9-digit tax identification number to validate
     * @return {@code true} if the NIF is mathematically valid, {@code false} otherwise
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
