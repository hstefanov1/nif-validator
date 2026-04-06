package io.github.hstefanov1.nifvalidator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NifValidatorTest {

    @ParameterizedTest
    @NullSource
    void shouldReturnFalseForNullInput(String nif) {
        assertFalse(NifValidator.isNif(nif));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "",
            " ",
            "1",
            "12345678",   // 8 digits
            "1234567890"  // 10 digits
    })
    void shouldReturnFalseForWrongLength(String nif) {
        assertFalse(NifValidator.isNif(nif));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "12345678A",
            "12345 678",
            "123-56789",
            " 12345678"
    })
    void shouldReturnFalseForNonDigitCharacters(String nif) {
        assertFalse(NifValidator.isNif(nif));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "545259040",
            "545259041",
            "545259042"
    })
    void shouldReturnFalseForInvalidCheckDigit(String nif) {
        assertFalse(NifValidator.isNif(nif));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "121712010",
            "161925600",
            "256317550",
            "280333340",
            "360911560",
            "386414580",
            "522359850",
            "500609390",
            "651414830",
            "664238750",
            "899335870",
            "818444770",
            "921205040",
            "946111260"
    })
    void shouldReturnTrueWhenCheckDigitIsClamped(String nif) {
        assertTrue(NifValidator.isNif(nif));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789",
            "124636675",
            "178916862",
            "143083368",
            "251305694",
            "342734016",
            "358133742",
            "339364483",
            "341999768",
            "365918881",
            "545259045",
            "516775308",
            "510105041",
            "546170595",
            "658307622",
            "679056564",
            "625323173",
            "830649441",
            "821235036",
            "897913728",
            "925014427",
            "970957882",
            "991878116"
    })
    void shouldReturnTrueForValidNif(String nif) {
        assertTrue(NifValidator.isNif(nif));
    }
}
