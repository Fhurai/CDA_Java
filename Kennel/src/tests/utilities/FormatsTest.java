package tests.utilities;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormatsTest {

    @ParameterizedTest
    @ValueSource(strings = {"45/12/1992", "04/25/2022", "28/05/21456"})
    void testFORMAT_DDMMYYYYInvalid(String date){
        assertThrows(DateTimeParseException.class, () -> LocalDate.parse(date));
    }

    @ParameterizedTest
    @ValueSource(strings = {"21/12/1992", "04/09/1995", "28/05/1960"})
    void testFORMAT_DDMMYYYYValid(String date){
        assertThrows(DateTimeParseException.class, () -> LocalDate.parse(date));
    }
}
